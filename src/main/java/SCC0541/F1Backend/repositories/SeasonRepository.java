package SCC0541.F1Backend.repositories;

import SCC0541.F1Backend.dtos.SeasonDTO;
import SCC0541.F1Backend.models.SeasonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonRepository extends JpaRepository<SeasonModel, Integer> {
}
