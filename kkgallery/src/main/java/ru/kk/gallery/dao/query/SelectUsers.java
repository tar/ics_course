package ru.kk.gallery.dao.query;

import org.springframework.jdbc.object.MappingSqlQuery;
import ru.kk.gallery.dao.entity.User;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectUsers extends MappingSqlQuery<User>{

    private static final String SQL_SELECT_ALL_USERS = "select * from users";

    public SelectUsers(DataSource dataSource)
    {
        super(dataSource, SQL_SELECT_ALL_USERS);
    }

    @Override
    protected User mapRow(ResultSet resultSet, int i) throws SQLException {
        return User.mapRow(resultSet,i);
    }
}
