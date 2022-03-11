package com.example.cajero;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper {

    public static final String DBNAME = "Usuarios.db";

    public DataBase(Context context, String baseDatos, Object o, int i) {
        super(context, "Usuarios.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase Datos) {
        Datos.execSQL("create table usuario(clave String primary key, saldo int)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase Datos, int i, int i1) {
        Datos.execSQL("drop Table if exists usuario");
    }

    public Boolean inserData(String clave, int saldo){
        SQLiteDatabase Datos = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("clave","1111");
        contentValues.put("saldo",1200000);
        long result = Datos.insert("usuario",null,contentValues);

        if (result==-1) return false;
        else
            return true;

    }

    public Boolean validarPass(String clave){
      SQLiteDatabase Datos = this.getWritableDatabase();
        Cursor cursor = Datos.rawQuery("select * from usuario where clave =?", new  String[] {clave} );
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public int validarSaldo(String clave){
        SQLiteDatabase Datos = this.getWritableDatabase();
        Cursor cursor = Datos.rawQuery("select saldo from usuario where clave ="+clave,null);
        if(cursor.moveToFirst()){
            return cursor.getInt(0);
        }

        else
            return 0;
    }





}
