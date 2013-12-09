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
    public List<User> getUsers() {

        return jdbcTemplate.query("select * from users", new UserMapper());

    }

    private static final class UserMapper implements RowMapper<User>
    {

        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {

            User user = new User();

            user.setLogin(resultSet.getString("login"));
            user.setDate_reg(resultSet.getDate("date_reg"));
            user.setEmail(resultSet.getString("email"));
            user.setId_city(resultSet.getLong("id_city"));
            user.setName(resultSet.getString("name"));
            user.setSurname(resultSet.getString("surname"));

            return user;
        }

    }

}
