package SCC0541.F1Backend.services;

import SCC0541.F1Backend.dtos.AirportDTO;
import SCC0541.F1Backend.repositories.AirportRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private AirportRepository airportRepository;

    public List<AirportDTO> list(){
        return airportRepository.findAll().stream()
                .map(a -> objectMapper.convertValue(a, AirportDTO.class))
                .toList();
    }
}
