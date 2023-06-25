package SCC0541.F1Backend.controllers;

import SCC0541.F1Backend.dtos.ConstructorDTO;
import SCC0541.F1Backend.dtos.CountryDTO;
import SCC0541.F1Backend.services.ConstructorService;
import SCC0541.F1Backend.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/countries") // localhost:8080/constructors
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping
    public List<CountryDTO> select(){
        return countryService.list();
    }

}