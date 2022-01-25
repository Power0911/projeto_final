package com.example.projeto_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class introducao extends AppCompatActivity {

    Button comecar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introducao);
        comecar= findViewById(R.id.btn_Comecar);
        comecar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(introducao.this , MainActivity.class);
                startActivity(intent);
            }
        });
    }
}