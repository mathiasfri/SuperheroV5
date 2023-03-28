package com.example.superherov5.Repositories;

import com.example.superherov5.Model.Superhero;
import com.example.superherov5.Model.SuperheroDTO;
import com.example.superherov5.Model.SuperheroList;
import com.example.superherov5.Model.Superpowers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SuperheroRepository {
    // Shows all superheroes in list
    public List<SuperheroList> getSuperheroes() {
        List<SuperheroList> superheroes = new ArrayList<>();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/main_schema", "root", "1234")) {
            String SQL1 = "SELECT DISTINCT superheroes.superheroID, heroName, realName, creationYear FROM superheroes;";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL1);
            while (rs.next()) {
                int ID = rs.getInt("superheroID");
                String heroName = rs.getString("heroName");
                String realName = rs.getString("realName");
                int creationYear = rs.getInt("creationYear");
                superheroes.add(new SuperheroList(ID, heroName, realName, creationYear));
            }
            return superheroes;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Superpowers getSuperpowers(String name){
        Superpowers superpowers1 = null;

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/main_schema", "root", "1234")) {
            String SQL1 = "SELECT superheroes.heroName, superpower.powerName\n" +
                    "FROM superheroes join superhero_superpower join superpower\n" +
                    "on superheroes.superheroID = superhero_superpower.superheroID\n" +
                    "and superpower.superpowerID = superhero_superpower.superpowerID\n" +
                    "WHERE heroName = ?;";

            PreparedStatement ps = con.prepareStatement(SQL1);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            String currentName = "";
            while (rs.next()) {
                String heroName = rs.getString("heroName");
                String powers = rs.getString("powerName");

                if (currentName.equals(heroName)){
                    superpowers1.addSuperPower(powers);
                }

                else {
                    superpowers1 = new Superpowers(heroName, new ArrayList<>(List.of(powers)));
                    currentName = heroName;
                }
            }
            return superpowers1;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getCities(){
        List<String> cities = new ArrayList<>();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/main_schema", "root", "1234")){
            String SQL = "SELECT cityName FROM city;";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while(rs.next()){
                String city = rs.getString("cityName");
                cities.add(city);
            }
            return cities;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<String> getSuperpowers(){
        List<String> superpowers = new ArrayList<>();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/main_schema", "root", "1234")){
            String SQL = "SELECT powerName FROM superpower;";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while(rs.next()){
                String city = rs.getString("powerName");
                superpowers.add(city);
            }
            return superpowers;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void addSuperhero(SuperheroDTO superheroDTO){
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/main_schema", "root", "1234")){
            int cityID = 0;
            int heroID = 0;
            List<Integer> powerIDList = new ArrayList<>();

            String SQL = "SELECT cityID FROM city WHERE cityName = ?;";
            PreparedStatement pstm = con.prepareStatement(SQL);
            pstm.setString(1, superheroDTO.getCity());
            ResultSet rs = pstm.executeQuery();
            if (rs.next()){
                cityID = rs.getInt("cityID");
            }

            String SQL2 = "INSERT INTO superheroes (heroName, realName, creationYear)" +
                    "VALUES (?, ?, ?);";
            pstm = con.prepareStatement(SQL2, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, superheroDTO.getHeroName());
            pstm.setString(2, superheroDTO.getRealName());
            pstm.setInt(3, superheroDTO.getCreationYear());

            int rows = pstm.executeUpdate();
            rs = pstm.getGeneratedKeys();
            if (rs.next()){
                heroID = rs.getInt(1);
            }

            String SQL3 = "SELECT superpowerID FROM superpower WHERE powerName = ?;";
            pstm = con.prepareStatement(SQL3);

            for (String power : superheroDTO.getPowers()){
                pstm.setString(1, power);
                rs = pstm.executeQuery();
                if (rs.next()){
                    powerIDList.add(rs.getInt("superpowerID"));
                }
            }

            String SQL4 = "INSERT INTO superhero_superpower (superheroID, superpowerID)" +
                    "VALUES (?, ?);";
            pstm = con.prepareStatement(SQL4);

            for (Integer i : powerIDList) {
                pstm.setInt(1, heroID);
                pstm.setInt(2, i);
                rows = pstm.executeUpdate();
            }
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
