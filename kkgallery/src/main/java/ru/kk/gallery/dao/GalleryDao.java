package ru.kk.gallery.dao;

import ru.kk.gallery.dao.entity.*;

import java.util.List;

public interface GalleryDao {

    public List<Style> getStyles();

    public List<Genre> getGenres();

    public List<Tag> getTags();

    //Cities

    public List<City> getCities();

    public List<City> getCity(int id_city);

    //Users

    public List<User> getUsers();

    public List<User> getUser(String login);

    //Paintings

    public List<Painting> getPaintings();

    public List<Painting> getPaintings(User user);

    public List<Painting> getPaintings(Genre genre);

    public List<Painting> getPaintings(Style style);

    public List<Painting> getPaintings(Tag tag);

    public Painting getPainting(int id_painting);

    //Images

    public List<Image> getImages(Painting painting);

}
