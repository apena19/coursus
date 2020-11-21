package com.admin.coursus;

public class Curso {

    private String id;
    private String nombre;
    private String duracion;
    private String categoria;
    private int featured_photo;

    public Curso(String id, String nombre, String duracion, String categoria, int featured_photo) {
        this.id = id;
        this.nombre = nombre;
        this.duracion = duracion;
        this.categoria = categoria;
        this.featured_photo = featured_photo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getFeatured_photo() {
        return featured_photo;
    }

    public void setFeatured_photo(int featured_photo) {
        this.featured_photo = featured_photo;
    }
}