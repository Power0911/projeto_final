package com.example.projeto_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class Historico extends AppCompatActivity {

    ListView lv_Historico;
    ImageButton btn_Voltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);

        lv_Historico=findViewById(R.id.lv_Historico);
        btn_Voltar=findViewById(R.id.Img_Voltar);

        ArrayList<Compras> historico;
        String hist[] ={""};
        Intent intent = new Intent(Historico.this, Pagina_principal.class);
        historico = (ArrayList<Compras>) getIntent().getSerializableExtra("Listas");
        if (historico!=null)
        {
            int icont=0;
            for (Compras name : historico)
            {
                hist[icont] = name.getMarca()+ ", "+name.getModelos() + ", " +name.getAno()+ ", " + name.getTiposwap();
                icont++;
            }
            ArrayAdapter<String> arr = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,hist);
            lv_Historico.setAdapter(arr);
        }
        btn_Voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Historico.this, Pagina_principal.class);
                startActivity(intent);
            }
        });
    }
}