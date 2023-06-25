package SCC0541.F1Backend.repositories;

import SCC0541.F1Backend.models.ConstructorModel;
import SCC0541.F1Backend.models.LapTimeModel;
import SCC0541.F1Backend.models.primary_keys.LapTimePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LapTimeRepository extends JpaRepository<LapTimeModel, LapTimePK> {

}
