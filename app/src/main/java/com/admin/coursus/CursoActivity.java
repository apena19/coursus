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
        //cursos = Data.obtenerC();

        cursos = new ArrayList<Curso>();
		cursos.add(new Curso("6737","Carlos","10 min", "PHP",R.drawable.images ));
        cursos.add(new Curso("22929","Carlos","10 horas","Economia",R.drawable.images2 ));
        cursos.add(new Curso("222","Carlos","48 dias","java",R.drawable.images3 ));

        adaptador = new AdaptadorCurso(cursos, this);

        llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);

        list_cursos.setLayoutManager(llm);
        list_cursos.setAdapter(adaptador);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }
    public void onCursoClick(Curso u) {
        Intent intent;
        Bundle bundle;

        bundle = new Bundle();

        bundle.putInt("featured_photo",u.getFeatured_photo());
        bundle.putString("nombre",u.getNombre());
        bundle.putString("categoria", u.getCategoria());
        bundle.putString("duracion", u.getDuracion());

        intent = new Intent(CursoActivity.this, DetalleCurso.class);
        intent.putExtra("datos",bundle);
        startActivity(intent);

    }
}