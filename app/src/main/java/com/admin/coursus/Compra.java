package com.admin.coursus;

public class Compra {
    private String id;
    private String cedula_User;
    private String id_curso;

    public Compra(String id, String cedula_User, String id_curso) {
        this.id = id;
        this.cedula_User = cedula_User;
        this.id_curso = id_curso;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCedula_User() {
        return cedula_User;
    }

    public void setCedula_User(String cedula_User) {
        this.cedula_User = cedula_User;
    }

    public String getId_curso() {
        return id_curso;
    }

    public void setId_curso(String id_curso) {
        this.id_curso = id_curso;
    }
}
