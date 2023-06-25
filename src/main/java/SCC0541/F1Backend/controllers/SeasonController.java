package SCC0541.F1Backend.controllers;

import SCC0541.F1Backend.dtos.SeasonDTO;
import SCC0541.F1Backend.services.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/seasons") // localhost:8080/circuits
public class SeasonController {

    @Autowired
    private SeasonService seasonService;

    @GetMapping
    public List<SeasonDTO> getAllSeasons(){
        return seasonService.getAllSeasons();
    }
}
