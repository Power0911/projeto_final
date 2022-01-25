package com.example.projeto_final;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DbDao  {

    private SQLiteDatabase db;
    private Dbhelper dbHelper; // instância da classe que criamos


    public DbDao(Context context) {
        dbHelper = new Dbhelper(context);
        db = dbHelper.getWritableDatabase();
    }


    @SuppressLint("Range")
    public ArrayList<CriarLogin> getTarefas() {
        String strSql = "select * from bd_tarefeiro";
        ArrayList contas = new ArrayList<CriarLogin>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor c = db.rawQuery(strSql, null);
        if (c.moveToFirst()) {
            do {
                CriarLogin criarLogin = new CriarLogin();
                criarLogin.setNome(c.getString(c.getColumnIndex("nome")));
                criarLogin.setCargo(c.getString(c.getColumnIndex("cargo")));
                contas.add(criarLogin);
            } while (c.moveToNext());
        }
        return contas;
    }

    public ArrayList<CriarLogin> pesquisar(String arg) {
        String strSql = "select * from bd_tarefeiro where nome like '%" + arg + "%'";
        ArrayList contas = new ArrayList<CriarLogin>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor c = db.rawQuery(strSql, null);
        if (c.moveToFirst()) {
            do {
                CriarLogin criarLogin = new CriarLogin();
                criarLogin.setNome(c.getString(c.getColumnIndexOrThrow("nome")));
                criarLogin.setCargo(c.getString(c.getColumnIndexOrThrow("cargo")));
                contas.add(criarLogin);
            } while (c.moveToNext());
        }
        return contas;
    }

    public void EliminarUtilizador(String nomeUtilizador){
        db.delete("bd_tarefeiro","nome= '" + nomeUtilizador + "'",null);
    }

    @SuppressLint("Range")
    public ArrayList<CriarLogin> getutilizador(String user) {
        String strSql = "select * from bd_tarefeiro where nome = '" + user + "'";
        ArrayList contas = new ArrayList<CriarLogin>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor c = db.rawQuery(strSql, null);
        if (c.moveToFirst()) {
            do {
                CriarLogin criarLogin = new CriarLogin();
                criarLogin.setNome(c.getString(c.getColumnIndex("nome")));
                criarLogin.setCargo(c.getString(c.getColumnIndex("cargo")));
                criarLogin.setPass(c.getString(c.getColumnIndex("pass")));
                contas.add(criarLogin);
            } while (c.moveToNext());
        }
        return contas;
    }

    public void alteraUtilizador(CriarLogin criarLogin, String nome_antigo){
        ContentValues contentValues=new ContentValues();
        contentValues.put("nome",criarLogin.getNome());
        contentValues.put("cargo",criarLogin.getCargo());
        contentValues.put("pass",criarLogin.getPass());
        db.update("bd_tarefeiro",contentValues,"nome ='"+ nome_antigo + "'",null);
    }

}


