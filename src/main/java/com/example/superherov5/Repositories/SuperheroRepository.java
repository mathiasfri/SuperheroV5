package com.example.superherov5.Repositories;

import com.example.superherov5.Model.Superhero;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SuperheroRepository {
    // Shows all superheroes in list
    public List<Superhero> getSuperheroes() {
        List<Superhero> superheroes = new ArrayList<>();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/main_schema", "root", "1234")) {
            String SQL1 = "SELECT * FROM superheroes;";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL1);
            while (rs.next()) {
                int ID = rs.getInt("superheroID");
                String heroName = rs.getString("heroName");
                String realName = rs.getString("realName");
                int creationYear = rs.getInt("creationYear");
                superheroes.add(new Superhero(ID, heroName, realName, creationYear));
            }
            return superheroes;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
