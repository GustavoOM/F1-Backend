package SCC0541.F1Backend.controllers;

import SCC0541.F1Backend.dtos.CircuitDTO;
import SCC0541.F1Backend.dtos.LapTimeDTO;
import SCC0541.F1Backend.services.LapTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/lap-times") // localhost:8080/circuits
public class LapTimeController {
    
    @Autowired
    private LapTimeService laptimeService;

    @GetMapping
    public List<LapTimeDTO> getAllLapTimes(){
        return laptimeService.list();
    }

}
