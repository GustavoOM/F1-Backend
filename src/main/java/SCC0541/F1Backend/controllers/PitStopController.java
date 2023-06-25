package SCC0541.F1Backend.controllers;

import SCC0541.F1Backend.dtos.LapTimeDTO;
import SCC0541.F1Backend.dtos.PitStopDTO;
import SCC0541.F1Backend.services.LapTimeService;
import SCC0541.F1Backend.services.PitStopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/pit-stops") // localhost:8080/pit-stops
public class PitStopController {

    @Autowired
    private PitStopService pitStopService;

    @GetMapping
    public List<PitStopDTO> getAllPitStops(){
        return pitStopService.getAllPitStops();
    }


}
