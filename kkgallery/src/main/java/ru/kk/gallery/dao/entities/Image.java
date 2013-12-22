package ru.kk.gallery.dao.entities;

public class Image {

    private int id_image;

    private int id_painting;

    private String path;

    public int getId_image() {
        return id_image;
    }

    public void setId_image(int id_image) {
        this.id_image = id_image;
    }

    public int getId_painting() {
        return id_painting;
    }

    public void setId_painting(int id_painting) {
        this.id_painting = id_painting;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
