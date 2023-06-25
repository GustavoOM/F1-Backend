package SCC0541.F1Backend.repositories;

import SCC0541.F1Backend.models.ResultModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends JpaRepository<ResultModel,Integer> {
}
