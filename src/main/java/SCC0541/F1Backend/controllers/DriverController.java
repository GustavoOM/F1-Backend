package SCC0541.F1Backend.controllers;

import SCC0541.F1Backend.dtos.ConstructorDTO;
import SCC0541.F1Backend.dtos.CreateDriverDTO;
import SCC0541.F1Backend.dtos.DriverDTO;
import SCC0541.F1Backend.services.DriverService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/drivers") // localhost:8080/drivers
public class DriverController {
    @Autowired
    private DriverService driverService;

    @GetMapping
    public List<DriverDTO> findAll(){
        return driverService.list();
    }

    @GetMapping("/{id}")
    public DriverDTO findById(@PathVariable("id") Integer id){
        return driverService.findById(id);
    }

    @PostMapping("/create")
    public void createDriver(@RequestBody @Valid CreateDriverDTO createDriverDTO) {
        driverService.createDriver(createDriverDTO);
    }

}
