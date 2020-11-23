package com.admin.coursus;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class DetalleCurso extends AppCompatActivity {
    private ImageView featured_photo;
    private TextView  nombre, categoria, duracion;
    private Intent intent;
    private Bundle bundle;
    private Curso c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_curso);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        featured_photo = findViewById(R.id.imgFotoDetalleC);
        nombre = findViewById(R.id.lblNombreDetalleC);
        categoria = findViewById(R.id.lblCategoriaDetalleC);
        duracion = findViewById(R.id.lblDuracionDetalleC);

        intent = getIntent();
        bundle = intent.getBundleExtra("datos");

        String  nom, cat, dur, id_curso;
        int fot;

        fot = bundle.getInt("featured_photo");
        nom = bundle.getString("nombre");
        cat = bundle.getString("categoria");
        dur = bundle.getString("duracion");
        featured_photo.setImageResource(fot);
        nombre.setText(nom);
        categoria.setText(cat);
        duracion.setText(dur);
        Random r = new Random();
        id_curso = Integer.toString( r.nextInt(56835) );

        c = new Curso(id_curso , nom, cat, dur, fot);

    }
    public void onBackPressed(){
        finish();
        Intent intent = new Intent(DetalleCurso.this, CursoActivity.class);
        startActivity(intent);

    }
}