package SCC0541.F1Backend.controllers;

import SCC0541.F1Backend.dtos.DriverStandingDTO;
import SCC0541.F1Backend.services.DriverStandingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/driver-standing") // localhost:8080/driver-standing
public class DriverStandingController {
    @Autowired
    private DriverStandingService driverStandingService;

    @GetMapping
    public List<DriverStandingDTO> select(){
        return driverStandingService.list();
    }
}
