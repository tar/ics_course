package ru.kk.gallery.dao.query;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import ru.kk.gallery.dao.entity.Painting;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectPainting extends MappingSqlQuery<Painting>{

    private static final String SQL_SELECT_PAINTING_BY_ID = "select * from paintings where id_painting=:id_painting";

    public SelectPainting(DataSource dataSource)
    {
        super(dataSource,SQL_SELECT_PAINTING_BY_ID);
        super.declareParameter(new SqlParameter("id_painting", Types.INTEGER));
    }

    public List<Painting> execute(int id_painting)
    {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id_painting", id_painting);

        return executeByNamedParam(paramMap);
    }

    @Override
    protected Painting mapRow(ResultSet resultSet, int i) throws SQLException {
        return Painting.mapRow(resultSet,i);
    }
}
