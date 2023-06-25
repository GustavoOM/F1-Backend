package SCC0541.F1Backend.repositories;

import SCC0541.F1Backend.models.CountryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<CountryModel, String> {
}
