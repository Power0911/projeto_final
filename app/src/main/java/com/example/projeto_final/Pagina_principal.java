package com.example.projeto_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Pagina_principal extends AppCompatActivity {
    Button btn_Calcular, btn_Historico, btn_Voltar, Historico;
    Spinner cbox_Marca, cbox_Modelos, cbox_Ano, cbox_Swap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_principal);

        btn_Calcular=findViewById(R.id.btn_Calcular);
        btn_Voltar=findViewById(R.id.btn_Voltar);
        btn_Historico=findViewById(R.id.btn_Historico);
        cbox_Marca=findViewById(R.id.cbox_Marcas);
        cbox_Modelos=findViewById(R.id.cbox_Modelos);
        cbox_Ano=findViewById(R.id.cbox_Ano);
        cbox_Swap=findViewById(R.id.cbox_Swap);

        //Botões
        btn_Voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Pagina_principal.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //Spinner Para as Marcas
        List<String> Marcas =new ArrayList<>();
        Marcas.add("");
        Marcas.add("BMW");
        Marcas.add("Mercedes");
        Marcas.add("Toyota");
        Marcas.add("Lexus");
        Marcas.add("Honda");
        Marcas.add("Bentley");
        Marcas.add("Jaguar");
        Marcas.add("Mini(BMW)");
        Marcas.add("Rolls Royce");
        Marcas.add("Volvo");
        Marcas.add("Audi");
        Marcas.add("Porsche");
        Marcas.add("Lamborgini");
        Marcas.add("Mitsubishi");
        Marcas.add("Nissan");
        Marcas.add("Ferrari");

        //create Adpter
        ArrayAdapter<String> dataAdapter =new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, (java.util.List<String>)Marcas);
        //Drop down layout style - listt view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        //Attaching data adapter to snniper
        cbox_Marca.setAdapter(dataAdapter);

        //spiner Para os Modelos
        List<String> Modelos=new ArrayList<>();
        Modelos.add("");
        Modelos.add("M3");
        Modelos.add("M4");
        Modelos.add("M5");
        Modelos.add("190D 2.0tdi");
        Modelos.add("190D 2.5 tdi Turdo");
        Modelos.add("W202");
        Modelos.add("Celica");
        Modelos.add("Cresta jzx100 1JZ");
        Modelos.add("Supra 2JZ Turdo Manual");
        Modelos.add("SUV0");
        Modelos.add("LC 500");
        Modelos.add("Sedan");
        Modelos.add("Civic GL");
        Modelos.add("Civic Classic");
        Modelos.add("Conserto");
        Modelos.add("GT Speed 12V");
        Modelos.add("GT Simples");
        Modelos.add("GT felipe TITO");
        Modelos.add("F-Type Coupé");
        Modelos.add("F Pace");
        Modelos.add("XE 4Portas");
        Modelos.add("Cooper");
        Modelos.add("Cooper S");
        Modelos.add("Cooper S JCW GP");
        Modelos.add("Cullinan");
        Modelos.add("Ghost");
        Modelos.add("Phantom");
        Modelos.add("V40");
        Modelos.add("XC 60");
        Modelos.add("XC 40");
        Modelos.add("A3");
        Modelos.add("A4");
        Modelos.add("A5");
        Modelos.add("Panamera");
        Modelos.add("Carreira");
        Modelos.add("GTS3");
        Modelos.add("Venom");
        Modelos.add("Huracan");
        Modelos.add("Diablo");
        Modelos.add("Lancer");
        Modelos.add("Eclipse");
        Modelos.add("ASX");
        Modelos.add("180SN");
        Modelos.add("350Z");
        Modelos.add("370Z");
        Modelos.add("F40");
        Modelos.add("F50");
        Modelos.add("Italy 450");
        //create Adpter
        ArrayAdapter<String> dataAdapter2 =new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, (java.util.List<String>)Modelos);
        //Drop down layout style - listt view with radio button
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_item);
        //Attaching data adapter to snniper
        cbox_Modelos.setAdapter(dataAdapter2);

        //spinner para o Ano
        List<String> Ano=new ArrayList<>();
        Ano.add("");
        Ano.add("1990-2000");
        Ano.add("2001-2005");
        Ano.add("2006-2010");
        Ano.add("2011-2016");
        Ano.add("2017-2021");
        //create Adpter
        ArrayAdapter<String> dataAdapter3 =new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, (java.util.List<String>)Ano);
        //Drop down layout style - listt view with radio button
        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_item);
        //Attaching data adapter to snniper
        cbox_Ano.setAdapter(dataAdapter3);


        ArrayList<Compras> historiconovo = new ArrayList<Compras>();
        //spinner para o tipo de Swap
        List<String> Tipo=new ArrayList<>();
        Tipo.add("");
        Tipo.add("Mudar de Motor");
        Tipo.add("Repro");
        Tipo.add("Mudar a estetica do Carro");
        //create Adpter
        ArrayAdapter<String> dataAdapter4 =new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, (java.util.List<String>)Tipo);
        //Drop down layout style - listt view with radio button
        dataAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_item);
        //Attaching data adapter to snniper
        cbox_Swap.setAdapter(dataAdapter4);

        //botao Calcular
        btn_Calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cbox_Marca.getSelectedItem().equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Insira uma Marca", Toast.LENGTH_SHORT).show();
                }
                else if (cbox_Modelos.getSelectedItem().equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Insira uma Modelo", Toast.LENGTH_SHORT).show();
                }
                else if (cbox_Ano.getSelectedItem().equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Insira um Ano", Toast.LENGTH_SHORT).show();
                }
                else if (cbox_Swap.getSelectedItem().equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Insira um Tipo de Swap", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Boa escolha ", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(Pagina_principal.this, Historico.class);

                    if (getIntent().getSerializableExtra("lista") == null){

                        Log.d("TAG", "onClick: ");
                        Compras AddCompras = new Compras(cbox_Marca.getSelectedItem().toString(),cbox_Modelos.getSelectedItem().toString(),cbox_Ano.getSelectedItem().toString(),cbox_Swap.getSelectedItem().toString());
                        historiconovo.add(AddCompras);
                        intent.putExtra("Listas", historiconovo);
                    }
                    else{
                      ArrayList<Compras> historico;
                        historico=(ArrayList<Compras>) getIntent().getSerializableExtra("lista");
                        Log.d("TAG", "onClick: 2");
                        Compras AddCompras = new Compras(cbox_Marca.getSelectedItem().toString(),cbox_Modelos.getSelectedItem().toString(),cbox_Ano.getSelectedItem().toString(),cbox_Swap.getSelectedItem().toString());
                        historico.add(AddCompras);
                        intent.putExtra("Listas", historico);

                    }
                }
            }
        });
        btn_Historico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Pagina_principal.this, Escolher.class);
                startActivity(intent);
            }
        });
    };
}