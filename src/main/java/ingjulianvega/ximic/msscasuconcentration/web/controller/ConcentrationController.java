package ingjulianvega.ximic.msscasuconcentration.web.controller;


import ingjulianvega.ximic.msscasuconcentration.services.ConcentrationService;
import ingjulianvega.ximic.msscasuconcentration.web.model.Concentration;
import ingjulianvega.ximic.msscasuconcentration.web.model.ConcentrationDto;
import ingjulianvega.ximic.msscasuconcentration.web.model.ConcentrationList;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ConcentrationController implements ConcentrationI {

    private final ConcentrationService concentrationService;

    @Override
    public ResponseEntity<ConcentrationList> get() {
        return new ResponseEntity<>(concentrationService.get(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ConcentrationDto> getById(@NotNull UUID id) {
        return new ResponseEntity<>(concentrationService.getById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> create(@NotNull @Valid Concentration concentration) {
        concentrationService.create(concentration);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> updateById(@NotNull UUID id, @NotNull @Valid Concentration concentration) {
        concentrationService.updateById(id, concentration);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Void> deleteById(@NotNull UUID id) {
        concentrationService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
