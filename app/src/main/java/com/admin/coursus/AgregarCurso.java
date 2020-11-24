package com.admin.coursus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Random;

public class AgregarCurso extends AppCompatActivity {
    private EditText  nombre, duracion;
    private CheckBox cat_1, cat_2, cat_3, cat_4;
    private String categorias = "";
    private ArrayList<Integer> featured_photo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_curso);

        nombre = findViewById(R.id.txtNombreCurso);
        duracion = findViewById(R.id.txtDuracion);
        cat_1 = (CheckBox) findViewById(R.id.cbxDS);
        cat_2 = (CheckBox) findViewById(R.id.cbx_D);
        cat_3 = (CheckBox) findViewById(R.id.cbx_EN);
        cat_4 = (CheckBox) findViewById(R.id.cbx_CT);


        featured_photo = new ArrayList<>();
        featured_photo.add(R.drawable.curso1);
        featured_photo.add(R.drawable.curso2);
        featured_photo.add(R.drawable.curso3);
        featured_photo.add(R.drawable.curso4);
        featured_photo.add(R.drawable.curso5);
    }
    public void guardar(View v){
        String  nom, dur, id_curso, cate;
        int featured_photo;
        Curso curso;
        nom = nombre.getText().toString();
        dur = duracion.getText().toString();
        cate = RevisarCategorias();
        featured_photo = foto_aleatoriaC();
        Random r = new Random();
        id_curso = Integer.toString( r.nextInt(56835) );
        curso = new Curso(id_curso, nom, dur, cate, featured_photo);
        curso.guardar();
        limpiar();
        Snackbar.make(v, R.string.mensaje_correcto, Snackbar.LENGTH_LONG).show();

    }
    public String RevisarCategorias(){
        String cat = categorias;
        if (cat_1.isChecked()==true) {
            cat = cat + cat_1.getText().toString() + ", ";
        }
        if (cat_2.isChecked()==true) {
            cat = cat + cat_2.getText().toString() + ", ";
        }
        if (cat_3.isChecked()==true) {
            cat = cat + cat_3.getText().toString() + ", ";
        }
        if (cat_4.isChecked()==true) {
            cat = cat + cat_4.getText().toString() + ", ";
        }
        return cat;
    }
    public int foto_aleatoriaC(){
        int id_foto_seleccionada;
        Random r = new Random();
        id_foto_seleccionada = r.nextInt(this.featured_photo.size());
        return featured_photo.get(id_foto_seleccionada);
    }
    public void limpiar(View v){
        limpiar();
    }
    public void limpiar(){
        nombre.setText("");
        duracion.setText("");
        cat_1.setChecked(false);
        cat_2.setChecked(false);
        cat_3.setChecked(false);
        cat_4.setChecked(false);
        nombre.requestFocus();
    }
    public void onBackPressed(){
        finish();
        Intent intent = new Intent(AgregarCurso.this, CursoActivity.class);
        startActivity(intent);
    }
    public void Cancelar(View v){
        finish();
        Intent intent = new Intent(AgregarCurso.this, CursoActivity.class);
        startActivity(intent);
    }
}