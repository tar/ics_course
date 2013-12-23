package ru.kk.gallery.dao.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Painting {

    //Fields

    private int id_painting;

    private String user_login;

    private String name;

    private Date date_added;

    private Date date_painted;

    private Double price;

    private int rating;

    //Properties

    public int getId_painting() {
        return id_painting;
    }

    public void setId_painting(int id_painting) {
        this.id_painting = id_painting;
    }

    public String getUser_login() {
        return user_login;
    }

    public void setUser_login(String user_login) {
        this.user_login = user_login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate_added() {
        return date_added;
    }

    public void setDate_added(Date date_added) {
        this.date_added = date_added;
    }

    public Date getDate_painted() {
        return date_painted;
    }

    public void setDate_painted(Date date_painted) {
        this.date_painted = date_painted;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    //Utils

    public static Painting mapRow(ResultSet rs, int i) throws SQLException {

        Painting painting = new Painting();

        painting.setId_painting(rs.getInt("id_painting"));
        painting.setName(rs.getString("name"));
        painting.setDate_added(rs.getDate("date_added"));
        painting.setDate_painted(rs.getDate("date_painted"));
        painting.setPrice(rs.getDouble("price"));
        painting.setRating(rs.getInt("rating"));
        painting.setUser_login(rs.getString("user_login"));

        return painting;
    }

}
