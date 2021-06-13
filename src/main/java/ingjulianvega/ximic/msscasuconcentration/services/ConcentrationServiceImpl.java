package ingjulianvega.ximic.msscasuconcentration.services;

import ingjulianvega.ximic.msscasuconcentration.configuration.ErrorCodeMessages;
import ingjulianvega.ximic.msscasuconcentration.domain.ConcentrationEntity;
import ingjulianvega.ximic.msscasuconcentration.domain.repositories.ConcentrationRepository;
import ingjulianvega.ximic.msscasuconcentration.exception.ConcentrationException;
import ingjulianvega.ximic.msscasuconcentration.web.Mappers.ConcentrationMapper;
import ingjulianvega.ximic.msscasuconcentration.web.model.Concentration;
import ingjulianvega.ximic.msscasuconcentration.web.model.ConcentrationDto;
import ingjulianvega.ximic.msscasuconcentration.web.model.ConcentrationList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
public class ConcentrationServiceImpl implements ConcentrationService {

    private final ConcentrationRepository concentrationRepository;
    private final ConcentrationMapper concentrationMapper;

    @Cacheable(cacheNames = "concentrationListCache", condition = "#usingCache == false")
    @Override
    public ConcentrationList get(Boolean usingCache) {
        log.debug("get()...");
        return ConcentrationList
                .builder()
                .concentrationList(concentrationMapper.concentrationEntityListToConcentrationDtoList(concentrationRepository.findAllByOrderByName()))
                .build();
    }

    @Cacheable(cacheNames = "concentrationCache")
    @Override
    public ConcentrationDto getById(UUID id) {
        log.debug("getById()...");
        return concentrationMapper.concentrationEntityToConcentrationDto(
                concentrationRepository.findById(id)
                        .orElseThrow(() -> new ConcentrationException(ErrorCodeMessages.CONCENTRATION_TYPE_NOT_FOUND, "")));
    }

    @Override
    public void create(Concentration concentration) {
        log.debug("create()...");
        concentrationMapper.concentrationEntityToConcentrationDto(
                concentrationRepository.save(
                        concentrationMapper.concentrationDtoToConcentrationEntity(
                                ConcentrationDto
                                        .builder()
                                        .name(concentration.getName())
                                        .abbreviation(concentration.getAbbreviation())
                                        .build())));
    }

    @Override
    public void updateById(UUID id, Concentration concentration) {
        log.debug("updateById...");
        ConcentrationEntity concentrationEntity = concentrationRepository.findById(id)
                .orElseThrow(() -> new ConcentrationException(ErrorCodeMessages.CONCENTRATION_TYPE_NOT_FOUND, ""));

        concentrationEntity.setName(concentration.getName());
        concentrationEntity.setAbbreviation(concentration.getAbbreviation());

        concentrationRepository.save(concentrationEntity);
    }

    @Override
    public void deleteById(UUID id) {
        log.debug("deleteById...");
        concentrationRepository.deleteById(id);
    }
}
