package ru.kk.gallery.dao;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcDao implements Dao, InitializingBean {

    //Private fields

    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    //Init methods

    public void setDataSource(DataSource dataSource)
    {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if(dataSource == null)
        {
            throw new BeanCreationException("Must set dataSource on Dao");
        }
    }

    //Getting data

    @Override
    public List<String> getStyles() {

        return jdbcTemplate.queryForList("select name from styles", String.class);

    }

    @Override
    public List<String> getGenres() {

        return jdbcTemplate.queryForList("select name from genres", String.class);

    }

    @Override
    public List<String> getTags() {

        return jdbcTemplate.queryForList("select name from tags", String.class);

    }

    //Cities

    @Override
    public List<City> getCities(){

        return jdbcTemplate.query("select * from cities", new CityMapper());

    }

    @Override
    public City getCity(int id_city){

        return jdbcTemplate.queryForObject("select * from cities where id_city=?", new Object[]{id_city},new CityMapper());

    }

    //Users

    @Override
    public List<User> getUsers() {

        return jdbcTemplate.query("select * from users", new UserMapper());

    }

    @Override
    public User getUser(String login) {

        return jdbcTemplate.queryForObject("select * from users where login=?", new Object[]{login}, new UserMapper());

    }

    //Paintings

    @Override
    public List<Painting> getPaintings() {

        return jdbcTemplate.query("select * from paintings", new PaintingMapper());

    }

    @Override
    public List<Painting> getPaintings(String user_login) {

        return jdbcTemplate.query("select * from paintings where user_login=?", new Object[]{user_login}, new PaintingMapper());

    }

    @Override
    public Painting getPainting(int id_painting) {

        return jdbcTemplate.queryForObject("select * from paintings where id_painting=?", new Object[]{id_painting}, new PaintingMapper());

    }

    //Mappers

    private final class UserMapper implements RowMapper<User>
    {

        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {

            User user = new User();

            user.setLogin(resultSet.getString("login"));
            user.setDate_reg(resultSet.getDate("date_reg"));
            user.setEmail(resultSet.getString("email"));
            City city = getCity(resultSet.getInt("id_city"));
            user.setCity(city);
            user.setName(resultSet.getString("name"));
            user.setSurname(resultSet.getString("surname"));

            return user;
        }

    }

    private final class CityMapper implements RowMapper<City>
    {

        @Override
        public City mapRow(ResultSet resultSet, int i) throws SQLException {

            City city = new City();

            city.setId_city(resultSet.getInt("id_city"));
            city.setName(resultSet.getString("name"));
            city.setCountry(resultSet.getString("country"));

            return city;
        }
    }

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
            User user = getUser(rs.getString("user_login"));
            painting.setUser(user);

            return painting;
        }
    }

}
