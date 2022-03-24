package com.example.cajero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class funciones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funciones);


    }

    public void iraSaldo(View view){
        String pass=getIntent().getStringExtra("password");
        Intent intente = new Intent(getApplicationContext(), saldo.class)
                .putExtra("password",pass);
        startActivity(intente);
    }
    public void iraRetirar(View view){
        String pass=getIntent().getStringExtra("password");
        Intent intent = new Intent(getApplicationContext(), retirar.class)
                .putExtra("password",pass);
        startActivity(intent);
    }
    public void iraTransferir(View view){
        String pass=getIntent().getStringExtra("password");
        Intent intent = new Intent(getApplicationContext(), transferir.class)
                .putExtra("password",pass);
        startActivity(intent);
    }



}