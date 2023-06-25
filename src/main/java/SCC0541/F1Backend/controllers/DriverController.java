package SCC0541.F1Backend.controllers;

import SCC0541.F1Backend.dtos.DriverDTO;
import SCC0541.F1Backend.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/drivers") // localhost:8080/drivers
public class DriverController {
    @Autowired
    private DriverService driverService;

    @GetMapping
    public List<DriverDTO> select(){
        return driverService.list();
    }
}
