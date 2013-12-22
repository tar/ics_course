package ru.kk.gallery.dao.query;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import ru.kk.gallery.dao.entity.User;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectUser extends MappingSqlQuery<User>{

    private static final String SQL_SELECT_USER_BY_LOGIN = "select * from users where login=:login";

    public SelectUser(DataSource dataSource)
    {
        super(dataSource, SQL_SELECT_USER_BY_LOGIN);
        super.declareParameter(new SqlParameter("login", Types.VARCHAR));
    }

    public List<User> execute(String login)
    {
        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("login",login);

        return executeByNamedParam(paramMap);
    }

    @Override
    protected User mapRow(ResultSet resultSet, int i) throws SQLException {
        return User.mapRow(resultSet,i);
    }
}
