package com.example.cajero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class retirar extends AppCompatActivity {
    TextView valor;
    DataBase bd;
    Button retirar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retirar);
        valor=(TextView) findViewById(R.id.valor);
        retirar =(Button) findViewById(R.id.retirar);
        bd = new DataBase(this, "BaseDatos", null, 1);
        String pass=getIntent().getStringExtra("password");



        retirar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String valo = valor.getText().toString();
                int sald= bd.validarSaldo(pass);
                int ret= Integer.parseInt(valor.getText().toString());
                int saldoresult= (sald-ret);

                if(valo.isEmpty())
                    Toast.makeText(retirar.this,"Por favor ingrese un valor",Toast.LENGTH_SHORT).show();
                else{
                    Boolean retirarr = bd.actualizar(pass,saldoresult);

                    if (retirarr==true ){

                        Toast.makeText(retirar.this, "Retiro Exitoso", Toast.LENGTH_SHORT).show();

                    }
                    else
                        Toast.makeText(retirar.this, "No se realizo el retiro", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}