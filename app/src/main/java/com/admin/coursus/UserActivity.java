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

public class UserActivity extends AppCompatActivity implements AdaptadorUsuario.OnUsuariolickListener {
    private RecyclerView list_usuarios;
    private AdaptadorUsuario adaptador;
    private LinearLayoutManager llm;
    private ArrayList<Usuario> usuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        list_usuarios = findViewById(R.id.lstUsuarios);
        usuarios = new ArrayList<Usuario>();
        usuarios.add(new Usuario("1143425645","Carlos","Perez", "3023175988", R.drawable.images ));
        usuarios.add(new Usuario("527628282","jairo","ffontalvo", "6276818", R.drawable.images2 ));

        adaptador = new AdaptadorUsuario(usuarios, this);
        llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);

        list_usuarios.setLayoutManager(llm);
        list_usuarios.setAdapter(adaptador);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    @Override
    public void onUsuarioClick(Usuario u) {
        Intent intent;
        Bundle bundle;

        bundle = new Bundle();

        bundle.putInt("foto",u.getFoto());
        bundle.putString("cedula", u.getCedula());
        bundle.putString("nombre",u.getNombre());
        bundle.putString("apellido", u.getApellido());
        bundle.putString("celular", u.getCelular());

        intent = new Intent(UserActivity.this, DetalleUsuario.class);
        intent.putExtra("datos",bundle);
        startActivity(intent);

    }

    public void onBackPressed(){
        finish();
        Intent intent = new Intent(UserActivity.this, MainActivity.class);
        startActivity(intent);

    }
}