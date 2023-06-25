package SCC0541.F1Backend.services;

import SCC0541.F1Backend.dtos.QualifyingDTO;
import SCC0541.F1Backend.dtos.RaceDTO;
import SCC0541.F1Backend.repositories.QualifyingRepository;
import SCC0541.F1Backend.repositories.RaceRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceService {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private RaceRepository raceRepository;

    public List<RaceDTO> list(){
        return raceRepository.findAll().stream()
                .map(q -> objectMapper.convertValue(q, RaceDTO.class))
                .toList();
    }
}
