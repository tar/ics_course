package ru.kk.gallery.dao.query;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import ru.kk.gallery.dao.entity.Painting;
import ru.kk.gallery.dao.entity.Style;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectPaintingsForStyle extends MappingSqlQuery<Painting> {

    private static final String SQL_SELECT_PAINTINGS_FOR_STYLE = "select * from paintings as p, painting_style as ps \n" +
                                                                 "where p.id_painting=ps.id_painting and ps.id_style=:id_style";

    public SelectPaintingsForStyle(DataSource dataSource)
    {
        super(dataSource, SQL_SELECT_PAINTINGS_FOR_STYLE);
        super.declareParameter(new SqlParameter("id_style", Types.INTEGER));
    }

    public List<Painting> execute(Style style)
    {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id_style", style.getId_style());

        return executeByNamedParam(paramMap);
    }

    @Override
    protected Painting mapRow(ResultSet resultSet, int i) throws SQLException {
        return Painting.mapRow(resultSet,i);
    }

}
