package com.example.superherov5.Model;

public class Superhero {
    private int superheroID;
    private String heroName;
    private String realName;

    private int creationYear;
    private String powers;
    private String city;

    public Superhero(int superheroID, String heroName, String realName, int creationYear, String powers, String city)
    {
        this.superheroID = superheroID;
        this.heroName = heroName;
        this.realName = realName;
        this.creationYear = creationYear;
        this.powers = powers;
        this.city = city;
    }

    public Superhero(){

    }

    public String getHeroName(){
        return heroName;
    }

    public void setHeroName(String heroName){
        this.heroName = heroName;
    }

    public String getRealName(){
        return realName;
    }

    public void setRealName(String realName){
        this.realName = realName;
    }

    public int getSuperheroID() {
        return superheroID;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public void setSuperheroID(int superheroID) {
        this.superheroID = superheroID;
    }

    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
    }

    public String getPowers() {
        return powers;
    }

    public void setPowers(String powers) {
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
        return  "ID: " + superheroID + "\n" +
                "Hero Name: " + heroName + "\n" +
                "Real name: " + realName + "\n" +
                "Creation Year: " + creationYear + "\n";
    }
}

