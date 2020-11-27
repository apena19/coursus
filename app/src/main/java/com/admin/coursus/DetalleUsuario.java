package com.admin.coursus;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetalleUsuario extends AppCompatActivity implements AdaptadorCurso.OnCursoClickListener {
    private ImageView foto;
    private TextView cedula, nombre, apellido, celular;
    private Intent intent;
    private Bundle bundle;
    private Usuario u;
    private ArrayList<Curso> cursos;
    private ArrayList<Compra> compras;
    private ArrayList<Curso> cursosUsuario = new ArrayList() ;
    private RecyclerView list_cursos_user;
    private AdaptadorCurso adaptador;
    private LinearLayoutManager llm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_usuario);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        foto = findViewById(R.id.imgFotoDetalleU);
        cedula = findViewById(R.id.lblCedulaDetalle);
        nombre = findViewById(R.id.lblNombreDetalle);
        apellido = findViewById(R.id.lblApellidoDetalle);
        celular = findViewById(R.id.lblCelularDetalle);


        intent = getIntent();
        bundle = intent.getBundleExtra("datos");

        String ced, nom, apell, cel;
        int fot;

        fot = bundle.getInt("foto");
        ced = bundle.getString("cedula");
        nom = bundle.getString("nombre");
        apell = bundle.getString("apellido");
        cel = bundle.getString("celular");
        foto.setImageResource(fot);
        cedula.setText(ced);
        nombre.setText(nom);
        apellido.setText(apell);
        celular.setText(cel);

        u = new Usuario(ced, nom, apell, cel,fot);

        cursos = Data.obtenerC();
        compras = Data.obtenerCp();
        String id_curso_temp;
        for (int i = 0; i < compras.size(); i++) {
            if(compras.get(i).getCedula_User().equals(ced)){
                id_curso_temp = compras.get(i).getId_curso();
                for (int j = 0; j < cursos.size();j++) {
                    if(cursos.get(i).getId().equals(id_curso_temp)){
                        cursosUsuario.add(cursos.get(j));
                        Log.i("cursoG:", cursos.get(j).getId());
                        Log.i("cursoG:", cursosUsuario.get(j).getId() );
                    }
                }
            }
        }

        list_cursos_user = findViewById(R.id.listCursosUser);

        adaptador = new AdaptadorCurso(cursosUsuario, this);
        llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);

        list_cursos_user.setLayoutManager(llm);
        list_cursos_user.setAdapter(adaptador);


    }
    public void eliminarUser(View v){
        String positivo, negativo;

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.titulo_eliminar_usuario);
        builder.setMessage(R.string.mensaje_eliminr_user);
        positivo = getString(R.string.opcion_si);
        negativo = getString(R.string.opcion_no);

        builder.setPositiveButton(positivo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                u.eliminar();
                onBackPressed();
            }
        });

        builder.setNegativeButton(negativo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

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

        intent = new Intent(DetalleUsuario.this, DetalleCurso.class);
        intent.putExtra("datos",bundle);
        startActivity(intent);

    }
    public void onBackPressed(){
        finish();
        Intent intent = new Intent(DetalleUsuario.this, UserActivity.class);
        startActivity(intent);

    }
}