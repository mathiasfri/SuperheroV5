package com.example.superherov5.Controllers;

import com.example.superherov5.Model.Superhero;
import com.example.superherov5.Model.SuperheroDTO;
import com.example.superherov5.Model.SuperheroList;
import com.example.superherov5.Model.Superpowers;
import com.example.superherov5.Services.SuperheroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("superhero")
public class SuperheroController {
    private SuperheroService superheroService;

    public SuperheroController() {
        superheroService = new SuperheroService();
    }

    @GetMapping("/")
    public String listSuperheroes(Model model){
        List<SuperheroList> superheroes = superheroService.getSuperheroes();
        model.addAttribute("superheroes", superheroes);

        return "index";
    }

    @GetMapping("/powers/{name}")
    public String superpowersList(@PathVariable String name, Model model){
        Superpowers superpowers = superheroService.getSuperpowers(name);
        model.addAttribute("name", name);
        model.addAttribute("superpowers", superpowers);

        return "superpowers";
    }

    @GetMapping("/add")
    public String addSuperhero(Model model){
        SuperheroDTO superheroDTO = new SuperheroDTO();
        model.addAttribute("superhero", superheroDTO);

        List<String> cities = superheroService.getCities();
        model.addAttribute("cities", cities);

        List<String> superpowers = superheroService.getSuperpowers();
        model.addAttribute("superpowerList", superpowers);
        return "addhero";
    }

    @PostMapping("/create")
    public String addSuperheroToDatabase(@ModelAttribute SuperheroDTO superheroDTO){
        superheroService.addSuperhero(superheroDTO);

        return "redirect:/superhero/";
    }

    @GetMapping("/remove/{superheroID}")
    public String removeSuperhero(@PathVariable int superheroID){
        superheroService.removeSuperhero(superheroID);

        return "redirect:/superhero/";
    }
}
