package SCC0541.F1Backend.controllers;


import SCC0541.F1Backend.dtos.RaceDTO;
import SCC0541.F1Backend.services.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/races") // localhost:8080/races
public class RaceController {
    @Autowired
    private RaceService raceService;

    @GetMapping
    public List<RaceDTO> select(){
        return raceService.list();
    }
}
