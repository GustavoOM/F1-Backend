package SCC0541.F1Backend.services;

import SCC0541.F1Backend.dtos.DriverDTO;
import SCC0541.F1Backend.repositories.DriverRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DriverService {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private DriverRepository driverRepository;

    public List<DriverDTO> list(){
        return driverRepository.findAll().stream()
                .map(d -> objectMapper.convertValue(d, DriverDTO.class))
                .toList();
    }

    //public DriverDTO createDriver(String driverRef, Integer number, String code, String forename, String surname, LocalDateTime birthDay, String nationality){
    //    return
    //}
}
