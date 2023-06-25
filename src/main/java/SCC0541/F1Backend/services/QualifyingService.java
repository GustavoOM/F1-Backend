package SCC0541.F1Backend.services;

import SCC0541.F1Backend.dtos.QualifyingDTO;
import SCC0541.F1Backend.repositories.QualifyingRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QualifyingService {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private QualifyingRepository qualifyingRepository;

    public List<QualifyingDTO> list(){
        return qualifyingRepository.findAll().stream()
                .map(q -> objectMapper.convertValue(q, QualifyingDTO.class))
                .toList();
    }
}