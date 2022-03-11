package com.example.cajero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String CLAVE = "clave";
    EditText pass;
    Button ingre;
    DataBase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        pass = (EditText) findViewById(R.id.clave);
        ingre =(Button) findViewById(R.id.ingresar);
        db = new DataBase(this, "BaseDatos", null, 1);

        ingre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String clave = pass.getText().toString();
                if(clave.isEmpty())
                    Toast.makeText(MainActivity.this,"Por favor ingrese la clave",Toast.LENGTH_SHORT).show();
                else{
                    Boolean validarPass = db.validarPass(clave);
                    Boolean reg =db.inserData("1111",1200000);
                    if (validarPass==true ){
                        String password= pass.getText().toString();
                        Toast.makeText(MainActivity.this, "Inicio correcto", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), funciones.class)
                        .putExtra("password",password);
                        startActivity(intent);
                    }
                    else
                        Toast.makeText(MainActivity.this, "Clave incorrecta", Toast.LENGTH_SHORT).show();
                }


            }
        }); // oyente del boton

    }




}