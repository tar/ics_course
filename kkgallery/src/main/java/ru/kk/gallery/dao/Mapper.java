package ru.kk.gallery.dao;

import ru.kk.gallery.dao.entity.Genre;
import ru.kk.gallery.dao.entity.Style;
import ru.kk.gallery.dao.entity.Tag;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Mapper {

    public static Style mapStyle(ResultSet rs, int i) throws SQLException {

        Style style = new Style();

        style.setId_style(rs.getInt("id_style"));
        style.setName(rs.getString("name"));

        return style;

    }

    public static Genre mapGenre(ResultSet rs, int i) throws SQLException {

        Genre genre = new Genre();

        genre.setId_genre(rs.getInt("id_genre"));
        genre.setName(rs.getString("name"));

        return genre;

    }

    public static Tag mapTag(ResultSet rs, int i) throws SQLException {

        Tag tag = new Tag();

        tag.setId_tag(rs.getInt("id_tag"));
        tag.setName(rs.getString("name"));

        return tag;

    }
}
