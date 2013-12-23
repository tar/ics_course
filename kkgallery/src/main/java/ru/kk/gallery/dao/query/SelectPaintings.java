package ru.kk.gallery.dao.query;

import org.springframework.jdbc.object.MappingSqlQuery;
import ru.kk.gallery.dao.entity.Painting;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectPaintings extends MappingSqlQuery<Painting>{

    private static final String SQL_SELECT_ALL_PAINTINGS = "select * from paintings";

    public SelectPaintings(DataSource dataSource)
    {
        super(dataSource,SQL_SELECT_ALL_PAINTINGS);
    }

    @Override
    protected Painting mapRow(ResultSet resultSet, int i) throws SQLException {

        return Painting.mapRow(resultSet, i);

    }
}
