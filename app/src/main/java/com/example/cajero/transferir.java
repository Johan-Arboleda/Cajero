package com.example.cajero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class transferir extends AppCompatActivity {
    TextView valor,user;
    DataBase bd;
    Button transferir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transferir);

        valor=(TextView) findViewById(R.id.valor);
        user=(TextView) findViewById(R.id.valor2);
        transferir =(Button) findViewById(R.id.transferir);
        bd = new DataBase(this, "BaseDatos", null, 1);
        String pass=getIntent().getStringExtra("password");

        transferir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String valo = valor.getText().toString();
                String users= user.getText().toString();
                int sald= bd.validarSaldo(pass);
                int sald1= bd.validarSaldo(users);
                int ret= Integer.parseInt(valor.getText().toString());
                int saldoresult= (sald-ret);
                int saldores2= (sald1+ret);

                if(valo.isEmpty())
                    Toast.makeText(transferir.this,"Por favor ingrese un valor",Toast.LENGTH_SHORT).show();
                else{
                    Boolean retirarr = bd.actualizar(pass,saldoresult);
                    Boolean retirar = bd.actualizar(users,saldores2);

                    if (retirarr==true && retirar==true ){

                        Toast.makeText(transferir.this, "Transferencia exitosa", Toast.LENGTH_SHORT).show();

                    }
                    else
                        Toast.makeText(transferir.this, "No se realizo la transferencia", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }
}