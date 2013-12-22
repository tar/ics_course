package ru.kk.gallery.dao.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Tag {

    //Fields

    private int id_tag;

    private String name;

    //Properties

    public int getId_tag() {
        return id_tag;
    }

    public void setId_tag(int id_tag) {
        this.id_tag = id_tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Utils

    public static Tag mapRow(ResultSet rs, int i) throws SQLException {

        Tag tag = new Tag();

        tag.setId_tag(rs.getInt("id_tag"));
        tag.setName(rs.getString("name"));

        return tag;

    }
}
