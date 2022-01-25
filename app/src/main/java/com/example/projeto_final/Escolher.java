package com.example.projeto_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Escolher extends AppCompatActivity {

    Button Login,Resgistos;
    ImageButton Voltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolher);

        Login =findViewById(R.id.btn_logins);
        Resgistos=findViewById(R.id.btn_Registos);
        Voltar=findViewById(R.id.btn_imagem);

        Voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent (Escolher.this, Pagina_principal.class);
                startActivity(intent);
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent (Escolher.this, Historico_final.class);
                startActivity(intent);            }
        });
        Resgistos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Escolher.this, Historico.class);
                startActivity(intent);
            }
        });
    }
}