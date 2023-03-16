package com.example.superherov5.Services;

import com.example.superherov5.Model.Superhero;
import com.example.superherov5.Repositories.SuperheroRepository;

import java.util.List;

public class SuperheroService {
    private SuperheroRepository superheroRepository;

    public SuperheroService() {
        this.superheroRepository = new SuperheroRepository();
    }

    public List<Superhero> getSuperheroes() {
        return superheroRepository.getSuperheroes();
    }
}
