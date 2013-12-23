package ru.kk.gallery.dao.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Image {

    //Fields

    private int id_image;

    private int id_painting;

    private String path;

    //Properties

    public int getId_image() {
        return id_image;
    }

    public void setId_image(int id_image) {
        this.id_image = id_image;
    }

    public int getId_painting() {
        return id_painting;
    }

    public void setId_painting(int id_painting) {
        this.id_painting = id_painting;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    //Utils

    public static Image mapRow(ResultSet rs, int i) throws SQLException {

        Image image = new Image();

        image.setId_image(rs.getInt("id_image"));
        image.setId_painting(rs.getInt("id_painting"));
        image.setPath(rs.getString("path"));

        return image;
    }
}
