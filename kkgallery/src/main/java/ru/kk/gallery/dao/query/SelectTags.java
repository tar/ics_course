package ru.kk.gallery.dao.query;

import org.springframework.jdbc.object.MappingSqlQuery;
import ru.kk.gallery.dao.entity.Tag;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTags extends MappingSqlQuery<Tag>{

    private static final String SQL_SELECT_ALL_TAGS = "select * from tags";

    public SelectTags(DataSource dataSource)
    {
        super(dataSource, SQL_SELECT_ALL_TAGS);
    }

    @Override
    protected Tag mapRow(ResultSet resultSet, int i) throws SQLException {
        return Tag.mapRow(resultSet, i);
    }
}
