package ru.kk.gallery.dao;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.kk.gallery.dao.entity.*;
import ru.kk.gallery.dao.query.*;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcGalleryDao implements GalleryDao, InitializingBean {

    //Private fields

    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    //Queries

    //Painting attributes

    private SelectStyles selectStyles;

    private SelectGenres selectGenres;

    private SelectTags selectTags;

    //Cities

    private SelectCities selectCities;

    private SelectCity selectCity;

    //Users

    private SelectUsers selectUsers;

    private SelectUser selectUser;

    //Paintings

    private SelectPaintings selectPaintings;

    private SelectPaintingsForUser selectPaintingsForUser;

    private SelectPaintingsForStyle selectPaintingsForStyle;

    private SelectPaintingsForGenre selectPaintingsForGenre;

    private SelectPaintingsForTag selectPaintingsForTag;

    private SelectPainting selectPainting;

    //Images

    private SelectImagesForPainting selectImagesForPainting;

    //Init methods

    public void setDataSource(DataSource dataSource)
    {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);

        selectStyles = new SelectStyles(dataSource);
        selectGenres = new SelectGenres(dataSource);
        selectTags = new SelectTags(dataSource);

        selectCities = new SelectCities(dataSource);
        selectCity = new SelectCity(dataSource);

        selectUsers = new SelectUsers(dataSource);
        selectUser = new SelectUser(dataSource);

        selectPaintings = new SelectPaintings(dataSource);
        selectPaintingsForUser = new SelectPaintingsForUser(dataSource);
        selectPaintingsForGenre = new SelectPaintingsForGenre(dataSource);
        selectPaintingsForStyle = new SelectPaintingsForStyle(dataSource);
        selectPaintingsForTag = new SelectPaintingsForTag(dataSource);
        selectPainting = new SelectPainting(dataSource);

        selectImagesForPainting = new SelectImagesForPainting(dataSource);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if(dataSource == null)
        {
            throw new BeanCreationException("Must set dataSource on GalleryDao");
        }
    }

    //Getting data

    //Painting attributes

    @Override
    public List<Style> getStyles() {

        return selectStyles.execute();

    }

    @Override
    public List<Genre> getGenres() {

        return selectGenres.execute();

    }

    @Override
    public List<Tag> getTags() {

        return selectTags.execute();

    }

    //Cities

    @Override
    public List<City> getCities(){

        return selectCities.execute();

    }

    @Override
    public List<City> getCity(int id_city){

        return selectCity.execute(id_city);

    }

    //Users

    @Override
    public List<User> getUsers() {

        return selectUsers.execute();

    }

    @Override
    public List<User> getUser(String login) {

        return selectUser.execute(login);

    }


    //Paintings

    @Override
    public List<Painting> getPaintings() {

        return selectPaintings.execute();

    }

    @Override
    public List<Painting> getPaintings(User user) {

        return selectPaintingsForUser.execute(user);

    }

    @Override
    public List<Painting> getPaintings(Genre genre) {

        return selectPaintingsForGenre.execute(genre);

    }

    @Override
    public List<Painting> getPaintings(Style style) {

        return selectPaintingsForStyle.execute(style);

    }

    @Override
    public List<Painting> getPaintings(Tag tag) {

        return selectPaintingsForTag.execute(tag);

    }

    @Override
    public List<Painting> getPainting(int id_painting) {

        return selectPainting.execute(id_painting);

    }

    //Images

    @Override
    public List<Image> getImages(Painting painting){

        return selectImagesForPainting.execute(painting);

    }

}
