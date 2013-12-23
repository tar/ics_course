package ru.kk.gallery.dao.query;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import ru.kk.gallery.dao.entity.Genre;
import ru.kk.gallery.dao.entity.Painting;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectPaintingsForGenre extends MappingSqlQuery<Painting>{

    private static final String SQL_SELECT_PAINTINGS_FOR_GENRE = "select * from paintings as p, painting_genre as pg \n" +
                                                                 "where p.id_painting=pg.id_painting and pg.id_genre=:id_genre";

    public SelectPaintingsForGenre(DataSource dataSource)
    {
        super(dataSource, SQL_SELECT_PAINTINGS_FOR_GENRE);
        super.declareParameter(new SqlParameter("id_genre", Types.INTEGER));
    }

    public List<Painting> execute(Genre genre)
    {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id_genre", genre.getId_genre());

        return executeByNamedParam(paramMap);
    }

    @Override
    protected Painting mapRow(ResultSet resultSet, int i) throws SQLException {
        return Painting.mapRow(resultSet,i);
    }

}
