package com.example.projeto_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_Login, btn_Resgistar;
    EditText txt_Login, txt_Pass;
    String utilizador;
    DbDao dbDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_Login=findViewById(R.id.btn_Login);
        btn_Resgistar=findViewById(R.id.btn_Resg);
        txt_Login=findViewById(R.id.txt_Login);
        txt_Pass=findViewById(R.id.txt_Pass);

        dbDao = new DbDao(this);
        Dbhelper dbhelper = new Dbhelper(this);
        //butao Login
        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             utilizador=txt_Login.getText().toString();
                Toast.makeText(getApplicationContext(),utilizador,Toast.LENGTH_LONG).show();
                if (txt_Login.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Nome de utilizador vazio", Toast.LENGTH_SHORT).show();
                }
                else if (txt_Pass.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Password vazia", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String username = txt_Login.getText().toString();
                    String password = txt_Pass.getText().toString();
                    String res = dbhelper.validarLogin(username, password);
                    if (res.equals("OK")){
                        Toast.makeText(getApplicationContext(), "Login OK", Toast.LENGTH_SHORT).show();
                        Intent intent =new Intent(MainActivity.this, Pagina_principal.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Ligação NOT ok", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
        //button Resgistar
        btn_Resgistar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this, Resgistar.class);
                startActivity(intent);
            }
        });
    }
}