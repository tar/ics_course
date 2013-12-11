package ru.kk.gallery.dao;

import java.util.List;

public interface Dao {

    public List<String> getStyles();

    public List<String> getGenres();

    public List<String> getTags();

    //Cities

    public List<City> getCities();

    public City getCity(int id_city);

    //Users

    public List<User> getUsers();

    public User getUser(String login);

    //Paintings

    public List<Painting> getPaintings();

    public List<Painting> getPaintings(String user_login);

    public Painting getPainting(int id_painting);

}
