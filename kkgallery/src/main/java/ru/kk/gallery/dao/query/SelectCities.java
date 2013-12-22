package ru.kk.gallery.dao.query;

import org.springframework.jdbc.object.MappingSqlQuery;
import ru.kk.gallery.dao.entity.City;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectCities extends MappingSqlQuery<City>{

    private static final String SQL_SELECT_ALL_CITIES = "select * from cities";

    public SelectCities(DataSource dataSource)
    {
        super(dataSource, SQL_SELECT_ALL_CITIES);
    }

    @Override
    protected City mapRow(ResultSet resultSet, int i) throws SQLException {
        return City.mapRow(resultSet, i);
    }
}
