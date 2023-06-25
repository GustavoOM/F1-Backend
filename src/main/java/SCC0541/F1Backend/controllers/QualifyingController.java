package SCC0541.F1Backend.controllers;

import SCC0541.F1Backend.dtos.QualifyingDTO;
import SCC0541.F1Backend.services.QualifyingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/qualifying") // localhost:8080/qualifying
public class QualifyingController {
    @Autowired
    private QualifyingService qualifyingService;

    @GetMapping
    public List<QualifyingDTO> select(){
        return qualifyingService.list();
    }
}
