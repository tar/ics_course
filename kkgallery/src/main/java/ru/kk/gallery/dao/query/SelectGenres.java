package ru.kk.gallery.dao.query;

import org.springframework.jdbc.object.MappingSqlQuery;
import ru.kk.gallery.dao.Mapper;
import ru.kk.gallery.dao.entity.Genre;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectGenres extends MappingSqlQuery<Genre>{

    private static final String SQL_SELECT_ALL_GENRES = "select * from genres";

    public SelectGenres(DataSource dataSource)
    {
        super(dataSource, SQL_SELECT_ALL_GENRES);
    }

    @Override
    protected Genre mapRow(ResultSet resultSet, int i) throws SQLException {
        return Mapper.mapGenre(resultSet,i);
    }

}
