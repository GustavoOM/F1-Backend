package SCC0541.F1Backend.controllers;


import SCC0541.F1Backend.dtos.ResultDTO;
import SCC0541.F1Backend.services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/results") // localhost:8080/results
public class ResultController {
    @Autowired
    private ResultService resultService;

    @GetMapping
    public List<ResultDTO> select() { return resultService.list(); }
}


