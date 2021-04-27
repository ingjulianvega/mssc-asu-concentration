package ingjulianvega.ximic.msscasuconcentration.web.Mappers;


import ingjulianvega.ximic.msscasuconcentration.domain.ConcentrationEntity;
import ingjulianvega.ximic.msscasuconcentration.web.model.ConcentrationDto;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(uses = DateMapper.class)
public interface ConcentrationMapper {
    ConcentrationDto concentrationEntityToConcentrationDto(ConcentrationEntity concentrationEntity);

    ConcentrationEntity concentrationDtoToConcentrationEntity(ConcentrationDto concentrationDto);

    ArrayList<ConcentrationDto> concentrationEntityListToConcentrationDtoList(List<ConcentrationEntity> concentrationEntityList);
}
