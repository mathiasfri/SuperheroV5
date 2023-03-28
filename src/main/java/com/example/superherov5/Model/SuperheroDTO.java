package com.example.superherov5.Model;

import java.util.List;

public class SuperheroDTO {
    private int superheroID;
    private String heroName;
    private String realName;

    private int creationYear;
    private List<String> powers;
    private String city;

    public SuperheroDTO(int superheroID, String heroName, String realName, int creationYear, List<String> powers, String city)
    {
        this.superheroID = superheroID;
        this.heroName = heroName;
        this.realName = realName;
        this.creationYear = creationYear;
        this.powers = powers;
        this.city = city;
    }

    public SuperheroDTO(){

    }

    public int getSuperheroID() {
        return superheroID;
    }

    public void setSuperheroID(int superheroID) {
        this.superheroID = superheroID;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
    }

    public List<String> getPowers() {
        return powers;
    }

    public void setPowers(List<String> powers) {
        this.powers = powers;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "SuperheroDTO{" +
                "superheroID=" + superheroID +
                ", heroName='" + heroName + '\'' +
                ", realName='" + realName + '\'' +
                ", creationYear=" + creationYear +
                ", powers=" + powers +
                ", city='" + city + '\'' +
                '}';
    }
}
