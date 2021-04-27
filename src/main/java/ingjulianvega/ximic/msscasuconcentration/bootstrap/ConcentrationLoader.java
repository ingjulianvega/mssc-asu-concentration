package ingjulianvega.ximic.msscasuconcentration.bootstrap;

import ingjulianvega.ximic.msscasuconcentration.domain.ConcentrationEntity;
import ingjulianvega.ximic.msscasuconcentration.domain.repositories.ConcentrationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@RequiredArgsConstructor
@Component
public class ConcentrationLoader implements CommandLineRunner {

    private final ConcentrationRepository concentrationRepository;

    @Override
    public void run(String... args) throws Exception {
        if (concentrationRepository.count() == 0) {
            loadConcentrationObjects();
        }
    }

    private void loadConcentrationObjects() {
        concentrationRepository.saveAll(Arrays.asList(
                ConcentrationEntity.builder().name("Gramos").abbreviation("gr").build(),
                ConcentrationEntity.builder().name("Miligramos").abbreviation("mg").build(),
                ConcentrationEntity.builder().name("Litros").abbreviation("lt").build(),
                ConcentrationEntity.builder().name("Mililitros").abbreviation("ml").build(),
                ConcentrationEntity.builder().name("Pastillas").abbreviation("pt").build(),
                ConcentrationEntity.builder().name("Cajas").abbreviation("cj").build(),
                ConcentrationEntity.builder().name("Otra").abbreviation("ot").build()
        ));
    }
}