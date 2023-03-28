package com.example.superherov5.Model;

public class SuperheroList {
    private int superheroID;
    private String heroName;
    private String realName;
    private int creationYear;

    public SuperheroList(int superheroID, String heroName, String realName, int creationYear){
        this.superheroID = superheroID;
        this.heroName = heroName;
        this.realName = realName;
        this.creationYear = creationYear;
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

    @Override
    public String toString() {
        return "SuperheroList{" +
                "superheroID=" + superheroID +
                ", heroName='" + heroName + '\'' +
                ", realName='" + realName + '\'' +
                ", creationYear=" + creationYear +
                '}';
    }
}
