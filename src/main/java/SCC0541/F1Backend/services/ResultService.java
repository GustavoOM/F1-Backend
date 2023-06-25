package SCC0541.F1Backend.services;

import SCC0541.F1Backend.dtos.ResultDTO;
import SCC0541.F1Backend.repositories.ResultRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ResultService {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ResultRepository resultRepository;

    public List<ResultDTO> list(){
        return resultRepository.findAll().stream()
                .map(q -> objectMapper.convertValue(q, ResultDTO.class))
                .toList();
    }
}
