package com.admin.coursus;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void flowusuarios(View v){
        Intent intent;
        intent = new Intent(MainActivity.this, UserActivity.class);
        startActivity(intent);
        finish();
    }
    public void flowCursos(View v){
        Intent intent;
        intent = new Intent(MainActivity.this, CursoActivity.class);
        startActivity(intent);
        finish();
    }
    public void flowCompra(View v){
        Intent intent;
        intent = new Intent(MainActivity.this, AgregarCompras.class);
        startActivity(intent);
        finish();
    }
}