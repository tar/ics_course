package ru.kk.gallery.dao.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class User {

    //Fields

    private String name;

    private String surname;

    private String email;

    private Date date_reg;

    private String login;

    private int id_city;

    //Properties

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId_city() {
        return id_city;
    }

    public void setId_city(int id_city) {
        this.id_city = id_city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate_reg() {
        return date_reg;
    }

    public void setDate_reg(Date date_reg) {
        this.date_reg = date_reg;
    }

    //Utils

    public static User mapRow(ResultSet rs, int i) throws SQLException {

        User user = new User();

        user.setLogin(rs.getString("login"));
        user.setDate_reg(rs.getDate("date_reg"));
        user.setEmail(rs.getString("email"));
        user.setId_city(rs.getInt("id_city"));
        user.setName(rs.getString("name"));
        user.setSurname(rs.getString("surname"));

        return user;
    }

}
