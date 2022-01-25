package com.example.projeto_final;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class Dbhelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "bd_tarefeiro";
    private static final int DATABASE_VERSION = 1;
    // String para criação da tabela tarefa
    public static final String tableTarefa = "create table bd_tarefeiro"
            + "(_id integer primary key autoincrement,"
            + " nome text not null,"
            + " pass text not null,"
            + " cargo text not null)";

    SQLiteDatabase db = getReadableDatabase();

    public Dbhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tableTarefa);
        Log.i("bd", "Bd criada com sucesso");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void inserirconta(CriarLogin criarLogin){

        ContentValues contentValues=new ContentValues();
        contentValues.put("nome",criarLogin.getNome());
        contentValues.put("pass",criarLogin.getPass());
        contentValues.put("cargo",criarLogin.getCargo());
        db.insert("bd_tarefeiro", null, contentValues);

    }

    public String validarLogin (String nome, String pass) {
    SQLiteDatabase db = getReadableDatabase();
    Cursor c = db.rawQuery("Select * FROM bd_tarefeiro WHERE nome=? AND pass=?", new String[]{nome, pass});
    if (c.getCount() > 0) {
        return "OK";
    }
    return "Error";
   }
}
