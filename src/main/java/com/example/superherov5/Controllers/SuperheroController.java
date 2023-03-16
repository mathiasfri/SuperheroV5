package com.example.superherov5.Controllers;

import com.example.superherov5.Model.Superhero;
import com.example.superherov5.Services.SuperheroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("superhero")
public class SuperheroController {
    private SuperheroService superheroService;

    public SuperheroController() {
        superheroService = new SuperheroService();
    }

    @GetMapping("/")
    public ResponseEntity<List<Superhero>> listSuperheroes(){
        List<Superhero> superheroes = superheroService.getSuperheroes();


        return new ResponseEntity<>(superheroes, HttpStatus.OK);
    }
}
