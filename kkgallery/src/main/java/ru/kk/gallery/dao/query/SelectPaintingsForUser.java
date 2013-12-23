package ru.kk.gallery.dao.query;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import ru.kk.gallery.dao.entity.Painting;
import ru.kk.gallery.dao.entity.User;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectPaintingsForUser extends MappingSqlQuery<Painting>{

    private static final String SQL_SELECT_PAINTINGS_FOR_USER = "select * from paintings where user_login=:user_login";

    public SelectPaintingsForUser(DataSource dataSource)
    {
        super(dataSource, SQL_SELECT_PAINTINGS_FOR_USER);

        super.declareParameter(new SqlParameter("user_login", Types.VARCHAR));
    }

    public List<Painting> execute(User user)
    {
        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("user_login", user.getLogin());

        return executeByNamedParam(paramMap);
    }

    @Override
    protected Painting mapRow(ResultSet resultSet, int i) throws SQLException {
        return Painting.mapRow(resultSet,i);
    }
}
