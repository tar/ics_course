package ru.kk.gallery.dao.query;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import ru.kk.gallery.dao.entity.Painting;
import ru.kk.gallery.dao.entity.Tag;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectPaintingsForTag extends MappingSqlQuery<Painting> {

    private static final String SQL_SELECT_PAINTINGS_FOR_TAG = "select * from paintings as p, painting_tag as pt \n" +
                                                               "where p.id_painting=pt.id_painting and pt.id_tag=:id_tag";

    public SelectPaintingsForTag(DataSource dataSource)
    {
        super(dataSource, SQL_SELECT_PAINTINGS_FOR_TAG);
        super.declareParameter(new SqlParameter("id_tag", Types.INTEGER));
    }

    public List<Painting> execute(Tag tag)
    {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id_tag", tag.getId_tag());

        return executeByNamedParam(paramMap);
    }

    @Override
    protected Painting mapRow(ResultSet resultSet, int i) throws SQLException {
        return Painting.mapRow(resultSet,i);
    }

}
