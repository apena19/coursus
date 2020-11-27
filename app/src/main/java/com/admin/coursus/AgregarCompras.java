package com.admin.coursus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Random;

public class AgregarCompras extends AppCompatActivity {
    private Spinner CursosLista;
    private EditText ced_user_compra;
    private ArrayList<Curso> cursos;
    private String[] listStringCursos;
    private String stringArrayTemp ;
    private ArrayList<Usuario> usuarios ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_compras);
        CursosLista = findViewById(R.id.spnCursosCompra);
        ced_user_compra = findViewById(R.id.txtCedulaCompra);
        cursos = Data.obtenerC();
        stringArrayTemp = getString(R.string.seleccionDefould) + ",";
        for (int i=0; i<cursos.size(); i++) {
            if(i == cursos.size()-1){
                stringArrayTemp +=  cursos.get(i).getNombre();
            }else{
                stringArrayTemp +=  cursos.get(i).getNombre() + "," ;
            }

        }
        listStringCursos = stringArrayTemp.split(",");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listStringCursos);
        CursosLista.setAdapter(adapter);
    }
    public void guardar(View v){
        if(validar()) {
            String  cedu, id_compra, id_curso;
            int pos_curso_lista;
            Compra compra;
            cedu = ced_user_compra.getText().toString();
            Random r = new Random();
            id_compra = Integer.toString( r.nextInt(682892972) );
            pos_curso_lista = CursosLista.getSelectedItemPosition();
            id_curso = BuscarIdCurso(pos_curso_lista);
            compra = new Compra(id_compra, cedu, id_curso);
            compra.guardar();
            limpiar();
            Snackbar.make(v, R.string.mensaje_correcto, Snackbar.LENGTH_LONG).show();
        }
    }

    public boolean validar(){
        if(ced_user_compra.getText().toString().isEmpty()){
            ced_user_compra.setError(getString(R.string.error));
            ced_user_compra.requestFocus();
            return  false;
        }
        usuarios = Data.obtenerU();
        boolean existe = false;
        String id_u = ced_user_compra.getText().toString();
        for (int i=0; i<usuarios.size(); i++) {
            if(id_u.equals(usuarios.get(i).getCedula())){
                existe = true;
            }
        }
        if(!existe){
            Toast.makeText(this, getString(R.string.error), Toast.LENGTH_LONG).show();
            return false;
        }
        if( CursosLista.getSelectedItemPosition() == 0){
            Toast.makeText(this, getString(R.string.error), Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    public String BuscarIdCurso(int pos){
        return  cursos.get(pos-1).getId();
    }
    public void limpiar(View v){
        limpiar();
    }
    public void limpiar(){
        ced_user_compra.setText("");
        CursosLista.setSelection(0);
        ced_user_compra.requestFocus();
    }
    public void onBackPressed(){
        finish();
        Intent intent = new Intent(AgregarCompras.this, MainActivity.class);
        startActivity(intent);
    }
    public void Cancelar(View v){
        finish();
        Intent intent = new Intent(AgregarCompras.this, MainActivity.class);
        startActivity(intent);
    }
}