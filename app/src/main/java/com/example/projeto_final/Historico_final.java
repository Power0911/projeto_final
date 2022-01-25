package com.example.projeto_final;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;

public class Historico_final extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    EditText txtPesquisar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico_final);

    txtPesquisar = findViewById(R.id.txtPesquisar);

        //carregar Recycler
        recyclerView = findViewById(R.id.rv_Historico);

        RecyclerView rcusers = (RecyclerView) findViewById(R.id.rv_Historico);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        rcusers.setLayoutManager(linearLayoutManager);
        adapatdor();

        txtPesquisar.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {

            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                procurar(txtPesquisar.getText().toString());
            }
        });

    }

    private void adapatdor(){
        ArrayList<CriarLogin> listarUsers = new ArrayList<CriarLogin>();
        DbDao dbDao = new DbDao(this);
        listarUsers = dbDao.getTarefas();
        AdpterUtilizzadores adpterUtilizzadores = new AdpterUtilizzadores(listarUsers);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adpterUtilizzadores);
    }
    private void procurar(String args){
        ArrayList<CriarLogin> listarUsers = new ArrayList<CriarLogin>();
        DbDao dbDao = new DbDao(this);
        listarUsers = dbDao.pesquisar(args);
        AdpterUtilizzadores adpterUtilizzadores = new AdpterUtilizzadores(listarUsers);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adpterUtilizzadores);
    }
}