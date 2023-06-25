package SCC0541.F1Backend.controllers;

import SCC0541.F1Backend.dtos.GeoCitiesDTO;
import SCC0541.F1Backend.dtos.LapTimeDTO;
import SCC0541.F1Backend.services.GeoCitiesService;
import SCC0541.F1Backend.services.LapTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Validated
@RestController
@RequestMapping("/geo-cities") // localhost:8080/geo-cities
public class GeoCitiesController {

    @Autowired
    private GeoCitiesService geoCitiesService;

    @GetMapping
    public List<GeoCitiesDTO> getAllGeoCities(){
        return geoCitiesService.getAllGeoCities();
    }

}