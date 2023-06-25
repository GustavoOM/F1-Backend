package SCC0541.F1Backend.services;

import SCC0541.F1Backend.dtos.CircuitDTO;
import SCC0541.F1Backend.repositories.CircuitRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CircuitService {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private CircuitRepository circuitsRepository;
    public List<CircuitDTO> list(){
        return circuitsRepository.findAll().stream()
                .map(c -> objectMapper.convertValue(c, CircuitDTO.class))
                .toList();
    }
}
