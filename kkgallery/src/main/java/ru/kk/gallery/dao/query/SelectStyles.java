package ru.kk.gallery.dao.query;

import org.springframework.jdbc.object.MappingSqlQuery;
import ru.kk.gallery.dao.Mapper;
import ru.kk.gallery.dao.entity.Style;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectStyles extends MappingSqlQuery<Style>{

    private final static String SQL_SELECT_ALL_STYLES = "select * from styles";

    public SelectStyles(DataSource dataSource)
    {
        super(dataSource, SQL_SELECT_ALL_STYLES);
    }

    @Override
    protected Style mapRow(ResultSet resultSet, int i) throws SQLException {
        return Mapper.mapStyle(resultSet, i);
    }
}
