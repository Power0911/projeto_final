package com.example.projeto_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Resgistar extends AppCompatActivity {
    Spinner cbox_Admin;
    EditText txtNome, txtPass, txtConfPass;
    Button registar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resgistar);
        DbDao dbDao = new DbDao(this);
        Dbhelper dbhelper = new Dbhelper(this);
        cbox_Admin=findViewById(R.id.cbox_Login);
        registar=findViewById(R.id.btn_registar);
        txtNome=findViewById(R.id.txt_Nome);
        txtConfPass=findViewById(R.id.txt_Conf_Pass);
        txtPass=findViewById(R.id.txt_Passs);
        registar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CriarLogin criarLogin = new CriarLogin(txtNome.getText().toString(), txtPass.getText().toString(),cbox_Admin.getSelectedItem().toString());
                dbhelper.inserirconta(criarLogin);
                Toast.makeText(getApplicationContext(), "Utilizador Registado!!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Resgistar.this, MainActivity.class);
                startActivity(intent);
            }
        });
        //spinner para o tipo de Swap
        List<String> Tipo=new ArrayList<>();
        Tipo.add("");
        Tipo.add("Amin");
        Tipo.add("Empregado");
        Tipo.add("Programador");
        //create Adpter
        ArrayAdapter<String> dataAdapter4 =new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, (java.util.List<String>)Tipo);
        //Drop down layout style - listt view with radio button
        dataAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_item);
        //Attaching data adapter to snniper
        cbox_Admin.setAdapter(dataAdapter4);
    }
}