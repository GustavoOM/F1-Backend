package SCC0541.F1Backend.services;

import SCC0541.F1Backend.dtos.CircuitDTO;
import SCC0541.F1Backend.dtos.GeoCitiesDTO;
import SCC0541.F1Backend.repositories.CircuitRepository;
import SCC0541.F1Backend.repositories.GeoCitiesRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeoCitiesService {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private GeoCitiesRepository geoCitiesRepository;
    public List<GeoCitiesDTO> getAllGeoCities(){
        return geoCitiesRepository.findAll().stream()
                .map(c -> objectMapper.convertValue(c, GeoCitiesDTO.class))
                .toList();
    }
}
