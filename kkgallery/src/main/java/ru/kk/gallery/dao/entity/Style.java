package ru.kk.gallery.dao.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Style {

    //Fields

    private int id_style;

    private String name;

    //Properties

    public int getId_style() {
        return id_style;
    }

    public void setId_style(int id_style) {
        this.id_style = id_style;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Utils

    public static Style mapRow(ResultSet rs, int i) throws SQLException {

        Style style = new Style();

        style.setId_style(rs.getInt("id_style"));
        style.setName(rs.getString("name"));

        return style;

    }
}
