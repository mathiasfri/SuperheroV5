package com.example.superherov5.Services;

import com.example.superherov5.Model.Superhero;
import com.example.superherov5.Model.SuperheroDTO;
import com.example.superherov5.Model.SuperheroList;
import com.example.superherov5.Model.Superpowers;
import com.example.superherov5.Repositories.SuperheroRepository;

import java.util.List;

public class SuperheroService {
    private SuperheroRepository superheroRepository;

    public SuperheroService() {
        this.superheroRepository = new SuperheroRepository();
    }

    public List<SuperheroList> getSuperheroes() {
        return superheroRepository.getSuperheroes();
    }

    public Superpowers getSuperpowers(String name){
        return superheroRepository.getSuperpowers(name);
    }

    public List<String> getCities(){
        return superheroRepository.getCities();
    }

    public List<String> getSuperpowers(){
        return superheroRepository.getSuperpowers();
    }

    public void addSuperhero(SuperheroDTO superheroDTO){
        superheroRepository.addSuperhero(superheroDTO);
    }
}
