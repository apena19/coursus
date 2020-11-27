package com.admin.coursus;

import java.util.ArrayList;

public class Data {
    //datos para usuarios
    private static ArrayList<Usuario> usuarios = new ArrayList();


    public static void guardarU(Usuario u){
        usuarios.add(u);
    }

    public static ArrayList<Usuario> obtenerU(){
        return usuarios;
    }


    public static void eliminarU(Usuario p){
        for (int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i).getCedula().equals(p.getCedula())){
                usuarios.remove(i);
                break;
            }
        }

    }

    //datos para curso
    private static ArrayList<Curso> cursos = new ArrayList();

    public static void guardarC(Curso c){
        cursos.add(c);
    }

    public static ArrayList<Curso> obtenerC(){
        return cursos;
    }

    public static void eliminarC(Curso c){
        for (int i = 0; i < cursos.size(); i++) {
            if(cursos.get(i).getId().equals(c.getId())){
                cursos.remove(i);
                break;
            }
        }

    }

    //datos para compras de cursos
    private static ArrayList<Compra> compras = new ArrayList();

    public static void guardarCp(Compra cp){
        compras.add(cp);
    }

    public static ArrayList<Compra> obtenerCp(){
        return compras;
    }

    public static void eliminarCp(Compra cp){
        for (int i = 0; i < compras.size(); i++) {
            if(compras.get(i).getId().equals(cp.getId())){
                compras.remove(i);
                break;
            }
        }

    }


}
