package SCC0541.F1Backend.controller;

import SCC0541.F1Backend.dto.CircuitDTO;
import SCC0541.F1Backend.service.CircuitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/circuits") // localhost:8080/circuits
public class CircuitController {
    @Autowired
    private CircuitService circuitService;

    @GetMapping
    public List<CircuitDTO> select(){
        return circuitService.list();
    }
}
