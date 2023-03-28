package com.example.superherov5.Model;

import java.util.List;

public class Superpowers {
    private String heroName;
    private List<String> powers;

    public Superpowers(String heroName, List<String> powers){
        this.heroName = heroName;
        this.powers = powers;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public List<String> getPowers() {
        return powers;
    }

    public void setPowers(List<String> powers) {
        this.powers = powers;
    }

    public void addSuperPower(String superpower){
        powers.add(superpower);
    }


}
