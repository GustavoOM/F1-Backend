package SCC0541.F1Backend.services;

import SCC0541.F1Backend.dtos.DriverStandingDTO;
import SCC0541.F1Backend.repositories.DriverStandingRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverStandingService {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private DriverStandingRepository driverStandingRepository;

    public List<DriverStandingDTO> list(){
        return driverStandingRepository.findAll().stream()
                .map(d -> objectMapper.convertValue(d, DriverStandingDTO.class))
                .toList();
    }
}
