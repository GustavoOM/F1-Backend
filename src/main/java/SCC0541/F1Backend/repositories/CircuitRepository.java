package SCC0541.F1Backend.repositories;

import SCC0541.F1Backend.models.CircuitModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CircuitRepository extends JpaRepository<CircuitModel,Integer> {

}
