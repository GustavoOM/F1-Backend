package SCC0541.F1Backend.services;

import SCC0541.F1Backend.dtos.ConstructorDTO;
import SCC0541.F1Backend.dtos.CreateConstructorDTO;
import SCC0541.F1Backend.repositories.ConstructorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConstructorService {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ConstructorRepository constructorRepository;

    public List<ConstructorDTO> list(){
        return  constructorRepository.findAll().stream()
                .map(c -> objectMapper.convertValue(c, ConstructorDTO.class))
                .toList();
    }

    public ConstructorDTO findById(Integer id) {
        return objectMapper.convertValue(
                constructorRepository.findById(id),ConstructorDTO.class
        );
    }

    public void createContructor(CreateConstructorDTO createConstructorDTO) {
        constructorRepository
                .create(
                        createConstructorDTO.getConstructorRef(),
                        createConstructorDTO.getName(),
                        createConstructorDTO.getNationality(),
                        createConstructorDTO.getUrl()
                );
    }
}
