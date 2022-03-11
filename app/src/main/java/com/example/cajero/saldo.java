package com.example.cajero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class saldo extends AppCompatActivity {
    TextView saldoG,sald;
    DataBase bd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saldo);

        saldoG=(TextView) findViewById(R.id.saldo);
        sald=(TextView) findViewById(R.id.sald);
        bd = new DataBase(this, "BaseDatos", null, 1);
        String pass=getIntent().getStringExtra("password");



        saldoG.setText(String.valueOf( bd.validarSaldo(pass)+"$"));
        sald.setText("Su saldo total es:");






    }



}