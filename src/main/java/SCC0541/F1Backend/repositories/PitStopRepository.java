package SCC0541.F1Backend.repositories;

import SCC0541.F1Backend.models.PitStopModel;
import SCC0541.F1Backend.models.primary_keys.PitStopPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PitStopRepository extends JpaRepository <PitStopModel, PitStopPK> {
}
