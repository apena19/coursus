package com.admin.coursus;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleUsuario extends AppCompatActivity {
    private ImageView foto;
    private TextView cedula, nombre, apellido, celular;
    private Intent intent;
    private Bundle bundle;
    private Usuario u;
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
    public void onBackPressed(){
        finish();
        Intent intent = new Intent(DetalleUsuario.this, UserActivity.class);
        startActivity(intent);

    }
}