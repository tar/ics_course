package ru.kk.gallery.dao.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Genre {

    //Fields

    private int id_genre;

    private String name;

    //Properties

    public int getId_genre() {
        return id_genre;
    }

    public void setId_genre(int id_genre) {
        this.id_genre = id_genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Utils

    public static Genre mapRow(ResultSet rs, int i) throws SQLException {

        Genre genre = new Genre();

        genre.setId_genre(rs.getInt("id_genre"));
        genre.setName(rs.getString("name"));

        return genre;

    }
}
