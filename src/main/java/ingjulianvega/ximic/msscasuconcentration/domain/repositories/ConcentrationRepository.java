package ingjulianvega.ximic.msscasuconcentration.domain.repositories;

import ingjulianvega.ximic.msscasuconcentration.domain.ConcentrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.UUID;

public interface ConcentrationRepository extends JpaRepository<ConcentrationEntity, UUID>, JpaSpecificationExecutor<ConcentrationEntity> {
    List<ConcentrationEntity> findAllByOrderByName();
}
