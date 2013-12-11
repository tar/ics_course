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

    public List<Painting> getPaintingsForGenre(int id_genre);

    public List<Painting> getPaintingsForStyle(int id_style);

    public List<Painting> getPaintingsForTag(int id_tag);

    public Painting getPainting(int id_painting);

    //Images

    public List<Image> getImages(int id_painting);

}
