package SCC0541.F1Backend.controllers;

import SCC0541.F1Backend.dtos.ConstructorDTO;
import SCC0541.F1Backend.services.ConstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
