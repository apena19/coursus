package com.admin.coursus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Random;

public class AgregarUsuario extends AppCompatActivity {
    private EditText cedula, nombre, apellido, celular;
    private ArrayList<Integer> fotos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregar_usuario);

        cedula = findViewById(R.id.txtCedula);
        nombre = findViewById(R.id.txtNombreCurso);
        apellido = findViewById(R.id.txtApellido);
        celular = findViewById(R.id.txtDuracion);

        fotos = new ArrayList<>();
        fotos.add(R.drawable.persona);
        fotos.add(R.drawable.persona1);
        fotos.add(R.drawable.persona2);
        fotos.add(R.drawable.persona3);
        fotos.add(R.drawable.persona4);
    }
    public void guardar(View v){
        String ced, nom, apell, cel;
        int foto;
        Usuario user;
        ced = cedula.getText().toString();
        nom = nombre.getText().toString();
        apell = apellido.getText().toString();
        cel = celular.getText().toString();
        foto = foto_aleatoria();
        if(validar()) {
            user = new Usuario(ced, nom, apell, cel, foto);
            user.guardar();
            limpiar();
            Snackbar.make(v, R.string.mensaje_correcto, Snackbar.LENGTH_LONG).show();
        }
    }
    public boolean validar(){

        if(cedula.getText().toString().isEmpty()){
            cedula.setError(getString(R.string.error));
            cedula.requestFocus();
            return  false;
        }
        if(nombre.getText().toString().isEmpty()){
            nombre.setError(getString(R.string.error));
            nombre.requestFocus();
            return  false;
        }
        if(apellido.getText().toString().isEmpty()){
            apellido.setError(getString(R.string.error));
            apellido.requestFocus();
            return  false;
        }
        if(celular.getText().toString().isEmpty()){
            celular.setError(getString(R.string.error));
            celular.requestFocus();
            return  false;
        }
        return true;
    }
    public int foto_aleatoria(){
        int id_foto_seleccionada;
        Random r = new Random();
        id_foto_seleccionada = r.nextInt(this.fotos.size());
        return fotos.get(id_foto_seleccionada);
    }
    public void limpiar(View v){
        limpiar();
    }

    public void limpiar(){
        cedula.setText("");
        nombre.setText("");
        apellido.setText("");
        celular.setText("");
        cedula.requestFocus();
    }
    public void onBackPressed(){
        finish();
        Intent intent = new Intent(AgregarUsuario.this, UserActivity.class);
        startActivity(intent);
    }
    public void Cancelar(View v){
        finish();
        Intent intent = new Intent(AgregarUsuario.this, UserActivity.class);
        startActivity(intent);
    }


}