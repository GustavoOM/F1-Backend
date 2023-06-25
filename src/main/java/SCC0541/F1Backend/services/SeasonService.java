package SCC0541.F1Backend.services;

import SCC0541.F1Backend.dtos.CircuitDTO;
import SCC0541.F1Backend.dtos.SeasonDTO;
import SCC0541.F1Backend.repositories.SeasonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeasonService {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    SeasonRepository seasonRepository;
    public List<SeasonDTO> getAllSeasons() {
        return seasonRepository.findAll().stream()
                .map(c -> objectMapper.convertValue(c, SeasonDTO.class))
                .toList();
    }

}
