package com.example.projeto_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class Editar extends AppCompatActivity {
    EditText Nome, Pass ;
    Spinner cargo;
    String Informacoes, cargos;
    Button btneditar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        Nome=findViewById(R.id.txt_Nome2);
        Pass=findViewById(R.id.txt_Passs2);
        cargo=findViewById(R.id.cbox_Cargo);
        btneditar=findViewById(R.id.btn_Editar);
        btneditar.setBackgroundColor(Color.parseColor("#00EEFF"));
        Intent intent = new Intent(Editar.this, AdpterUtilizzadores.class);
        Informacoes = getIntent().getStringExtra("nome");
        cargos = getIntent().getStringExtra("cargo");
        Nome.setText(Informacoes);


        //spinner para o Ano
        List<String> cargos=new ArrayList<>();
        cargos.add("Admin");
        cargos.add("Programador");
        cargos.add("Empregado");

        //create Adpter
        ArrayAdapter<String> dataAdapter3 =new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, (java.util.List<String>)cargos);
        //Drop down layout style - listt view with radio button
        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_item);
        //Attaching data adapter to snniper
        cargo.setAdapter(dataAdapter3);

        if (cargos.equals("Admin")){
            cargo.setSelection(0);
        }else if (cargos.equals("Programador")){
            cargo.setSelection(1);
        }else{
            cargo.setSelection(2);
        }

        DbDao dbDao = new DbDao(this);
        ArrayList<CriarLogin> user = dbDao.getutilizador(Informacoes);
        Pass.setText(user.get(0).pass);

        btneditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CriarLogin criarLogin = new CriarLogin(Nome.getText().toString(), Pass.getText().toString(), cargo.getSelectedItem().toString());
                dbDao.alteraUtilizador(criarLogin,Informacoes);
                Intent intent1 = new Intent(Editar.this, Historico_final.class);
                startActivity(intent1);
            }
        });
    }
}