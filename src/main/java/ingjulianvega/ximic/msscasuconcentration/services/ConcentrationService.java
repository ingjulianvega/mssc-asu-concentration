package ingjulianvega.ximic.msscasuconcentration.services;


import ingjulianvega.ximic.msscasuconcentration.web.model.Concentration;
import ingjulianvega.ximic.msscasuconcentration.web.model.ConcentrationDto;
import ingjulianvega.ximic.msscasuconcentration.web.model.ConcentrationList;

import java.util.UUID;

public interface ConcentrationService {
    ConcentrationList get(Boolean usingCache);

    ConcentrationDto getById(UUID id);

    void create(Concentration concentration);

    void updateById(UUID id, Concentration concentration);

    void deleteById(UUID id);
}
