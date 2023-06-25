package SCC0541.F1Backend.services;

import SCC0541.F1Backend.dtos.AirportDTO;
import SCC0541.F1Backend.dtos.CountryDTO;
import SCC0541.F1Backend.repositories.AirportRepository;
import SCC0541.F1Backend.repositories.CountryRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private CountryRepository countryRepository;
    public List<CountryDTO> list(){
        return countryRepository.findAll().stream()
                .map(c -> objectMapper.convertValue(c, CountryDTO.class))
                .toList();
    }

}
