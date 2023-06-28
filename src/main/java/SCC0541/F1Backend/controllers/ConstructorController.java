package SCC0541.F1Backend.controllers;

import SCC0541.F1Backend.dtos.ConstructorDTO;
import SCC0541.F1Backend.dtos.CreateConstructorDTO;
import SCC0541.F1Backend.services.ConstructorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/constructors") // localhost:8080/constructors
public class ConstructorController {
    @Autowired
    private ConstructorService constructorService;

    @GetMapping
    public List<ConstructorDTO> select(){
        return constructorService.list();
    }

    @GetMapping("/{id}")
    public ConstructorDTO findById(@PathVariable("id") Integer id){
        return constructorService.findById(id);
    }

    @PostMapping("/create")
    public void createContructor(@RequestBody @Valid CreateConstructorDTO createConstructorDTO) { constructorService.createContructor(createConstructorDTO); }
}
