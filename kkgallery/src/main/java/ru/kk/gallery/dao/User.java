package ru.kk.gallery.dao;

import java.util.Date;

public class User {

    private String name;

    private String surname;

    private String email;

    private Date date_reg;

    private String login;

    private long id_city;


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public long getId_city() {
        return id_city;
    }

    public void setId_city(long id_city) {
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




    @Override
    public String toString()
    {
        return login;
    }

}
