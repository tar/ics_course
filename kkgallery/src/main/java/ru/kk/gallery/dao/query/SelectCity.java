package ru.kk.gallery.dao.query;


import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import ru.kk.gallery.dao.entity.City;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectCity extends MappingSqlQuery<City>{

    private static final String SQL_SELECT_CITY_BY_ID = "select * from cities where id_city=:id_city";

    public SelectCity(DataSource dataSource)
    {
        super(dataSource, SQL_SELECT_CITY_BY_ID);
        super.declareParameter(new SqlParameter("id_city", Types.INTEGER));
    }

    public List<City> execute(int id_city)
    {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id_city", id_city);

        return executeByNamedParam(paramMap);
    }

    @Override
    protected City mapRow(ResultSet resultSet, int i) throws SQLException {
        return City.mapRow(resultSet, i);
    }
}
