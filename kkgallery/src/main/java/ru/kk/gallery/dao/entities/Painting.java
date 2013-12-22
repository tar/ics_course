package ru.kk.gallery.dao.entities;

import java.util.Date;

public class Painting {

    //Fields

    private int id_painting;

    private User user;

    private String name;

    private Date date_added;

    private Date date_painted;

    private Double price;

    //Properties

    public int getId_painting() {
        return id_painting;
    }

    public void setId_painting(int id_painting) {
        this.id_painting = id_painting;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    private int rating;

}
