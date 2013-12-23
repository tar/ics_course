package ru.kk.gallery.dao.query;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import ru.kk.gallery.dao.entity.Image;
import ru.kk.gallery.dao.entity.Painting;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectImagesForPainting extends MappingSqlQuery<Image>{

    private static final String SQL_SELECT_IMAGES_FOR_PAINTING = "select * from images where id_painting=:id_painting";

    public SelectImagesForPainting(DataSource dataSource)
    {
        super(dataSource,SQL_SELECT_IMAGES_FOR_PAINTING);
        super.declareParameter(new SqlParameter("id_painting", Types.INTEGER));
    }

    public List<Image> execute(Painting painting)
    {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id_painting", painting.getId_painting());

        return executeByNamedParam(paramMap);
    }

    @Override
    protected Image mapRow(ResultSet resultSet, int i) throws SQLException {
        return Image.mapRow(resultSet,i);
    }
}
