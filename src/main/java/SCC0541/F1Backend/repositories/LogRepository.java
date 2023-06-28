package SCC0541.F1Backend.repositories;

import SCC0541.F1Backend.models.AirportModel;
import SCC0541.F1Backend.models.LogModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<LogModel,Integer> {

    @Modifying
    @Query(value = "INSERT INTO log_table (id, id_original, timestamp) VALUES (:id, :idOriginal)", nativeQuery = true)
    int createLog(@Param("id") int id, @Param("idOriginal") int idOriginal);

}
