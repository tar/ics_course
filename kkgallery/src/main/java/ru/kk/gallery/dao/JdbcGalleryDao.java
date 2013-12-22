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

        return jdbcTemplate.query("select * from paintings", new PaintingMapper());

    }

    @Override
    public List<Painting> getPaintings(User user) {

        return jdbcTemplate.query("select * from paintings where user_login=?", new Object[]{user.getLogin()}, new PaintingMapper());

    }

    @Override
    public List<Painting> getPaintings(Genre genre) {

        return jdbcTemplate.query("select * from paintings as p, painting_genre as pg \n" +
                                  "where p.id_painting=pg.id_painting and pg.id_genre=?", new Object[]{genre.getId_genre()}, new PaintingMapper());

    }

    @Override
    public List<Painting> getPaintings(Style style) {

        return jdbcTemplate.query("select * from paintings as p, painting_style as ps \n" +
                                  "where p.id_painting=ps.id_painting and ps.id_style=?", new Object[]{style.getId_style()}, new PaintingMapper());

    }

    @Override
    public List<Painting> getPaintings(Tag tag) {

        return jdbcTemplate.query("select * from paintings as p, painting_tag as pt \n" +
                                  "where p.id_painting=pt.id_painting and pt.id_tag=?", new Object[]{tag.getId_tag()}, new PaintingMapper());

    }

    @Override
    public Painting getPainting(int id_painting) {

        return jdbcTemplate.queryForObject("select * from paintings where id_painting=?", new Object[]{id_painting}, new PaintingMapper());

    }

    //Images

    @Override
    public List<Image> getImages(Painting painting){
        return jdbcTemplate.query("select * from images where id_painting=?", new Object[]{painting.getId_painting()}, new ImageMapper());
    }

    //Mappers


    private final class PaintingMapper implements RowMapper<Painting>
    {

        @Override
        public Painting mapRow(ResultSet rs, int i) throws SQLException {

            Painting painting = new Painting();

            painting.setId_painting(rs.getInt("id_painting"));
            painting.setName(rs.getString("name"));
            painting.setDate_added(rs.getDate("date_added"));
            painting.setDate_painted(rs.getDate("date_painted"));
            painting.setPrice(rs.getDouble("price"));
            painting.setRating(rs.getInt("rating"));
            //User user = getUser(rs.getString("user_login"));
            //painting.setUser(user);

            return painting;
        }
    }

    private final class ImageMapper implements RowMapper<Image>
    {

        @Override
        public Image mapRow(ResultSet rs, int i) throws SQLException {

            Image image = new Image();

            image.setId_image(rs.getInt("id_image"));
            image.setId_painting(rs.getInt("id_painting"));
            image.setPath(rs.getString("path"));

            return image;
        }
    }

}
