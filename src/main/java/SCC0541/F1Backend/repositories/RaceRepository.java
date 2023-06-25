package SCC0541.F1Backend.repositories;

import SCC0541.F1Backend.models.RaceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceRepository extends JpaRepository<RaceModel, Integer> {
}
