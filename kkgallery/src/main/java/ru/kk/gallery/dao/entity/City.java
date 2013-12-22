package ru.kk.gallery.dao.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class City {

    //Fields

    private int id_city;

    private String name;

    private String country;

    //Properties

    public int getId_city() {
        return id_city;
    }

    public void setId_city(int id_city) {
        this.id_city = id_city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    //Utils

    public static City mapRow(ResultSet rs, int i) throws SQLException {

        City city = new City();

        city.setId_city(rs.getInt("id_city"));
        city.setName(rs.getString("name"));
        city.setCountry(rs.getString("country"));

        return city;

    }

}
