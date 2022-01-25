package com.example.projeto_final;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdpterUtilizzadores extends RecyclerView.Adapter<AdpterUtilizzadores.ViewHolder> {
    private ArrayList<CriarLogin> Registos;
    Context context;

    public AdpterUtilizzadores(ArrayList<CriarLogin> Registos){this.Registos=Registos;}

    @NonNull
    @Override
    public AdpterUtilizzadores.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_utilizador, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdpterUtilizzadores.ViewHolder holder, int position) {
           String utilizador = String.valueOf(Registos.get(position).getNome());
           String cargos = String.valueOf(Registos.get(position).getCargo());
           holder.lb_nome.setText(utilizador);
           holder.cargo.setText(cargos);
           holder.btn_imgAlterar.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {

                   Intent intent = new Intent(view.getContext(), Editar.class);
                   intent.putExtra("nome", utilizador);
                   intent.putExtra("cargo", cargos);
                   view.getContext().startActivity(intent);
               }
           });

           holder.btn_imgEliminar.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   DbDao dbDao = new DbDao(view.getContext());
                   dbDao.EliminarUtilizador(utilizador);
                   Intent intent = new Intent(view.getContext(), Historico_final.class);
                   view.getContext().startActivity(intent);
               }
           });
    }

    @Override
    public int getItemCount() {
        return Registos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView lb_nome, cargo;
        ImageButton btn_imgAlterar, btn_imgEliminar;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            lb_nome =itemView.findViewById(R.id.lb_nome);
            cargo = itemView.findViewById(R.id.lb_Cargo);
            btn_imgEliminar = itemView.findViewById(R.id.btn_imgEliminar);
            btn_imgAlterar = itemView.findViewById(R.id.btn_imgAlterar);
        }
    }
}
