package com.admin.coursus;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.ArrayList;

public class CursoActivity extends AppCompatActivity implements AdaptadorCurso.OnCursoClickListener{
    private RecyclerView list_cursos;
    private AdaptadorCurso adaptador;
    private LinearLayoutManager llm;
    private ArrayList<Curso> cursos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curso);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        list_cursos = findViewById(R.id.lstCursos);
        cursos = Data.obtenerC();
        adaptador = new AdaptadorCurso(cursos, this);

        llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);

        list_cursos.setLayoutManager(llm);
        list_cursos.setAdapter(adaptador);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(CursoActivity.this, AgregarCurso.class);
                startActivity(intent);
                finish();
            }
        });

    }
    public void onCursoClick(Curso c) {
        Intent intent;
        Bundle bundle;

        bundle = new Bundle();

        bundle.putInt("featured_photo",c.getFeatured_photo());
        bundle.putString("nombre",c.getNombre());
        bundle.putString("categoria", c.getCategoria());
        bundle.putString("duracion", c.getDuracion());
        bundle.putString("id_curso", c.getId());

        intent = new Intent(CursoActivity.this, DetalleCurso.class);
        intent.putExtra("datos",bundle);
        startActivity(intent);

    }
}