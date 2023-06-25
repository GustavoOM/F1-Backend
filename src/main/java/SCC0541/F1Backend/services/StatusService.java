package SCC0541.F1Backend.services;

import SCC0541.F1Backend.dtos.StatusDTO;
import SCC0541.F1Backend.repositories.StatusRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    StatusRepository seasonRepository;

    public List<StatusDTO> getAllStatus() {
        return seasonRepository.findAll().stream()
                .map(c -> objectMapper.convertValue(c, StatusDTO.class))
                .toList();
    }
}