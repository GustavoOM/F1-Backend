package SCC0541.F1Backend.repositories;

import SCC0541.F1Backend.dtos.CreateConstructorDTO;
import SCC0541.F1Backend.models.ConstructorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstructorRepository extends JpaRepository<ConstructorModel, Integer> {

    @Query(nativeQuery = true, value = "" +
            "CREATE SEQUENCE IF NOT EXISTS SEQ_CONSTRUCTOR_ID \n" +
            "START 220 \n" +
            "NO CYCLE \n" +
            "OWNED BY CONSTRUCTOR.constructor.id;")
    public void getSequence();


    @Query(nativeQuery = true, value = "INSERT INTO CONSTRUCTORS (constructorid, constructorref, name, nationality, url) VALUES (216,:constructorRef,:name,:nationality, :url)")
    public void create(  @Param("constructorRef") String constructorRef,
                           @Param("name") String name,
                           @Param("nationality") String nationality,
                           @Param("url") String url);

}