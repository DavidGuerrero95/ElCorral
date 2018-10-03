package com.lenovoexample.maps;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListadoAdapter extends RecyclerView.Adapter<ListadoAdapter.ViewHolder> implements View.OnClickListener{

    ArrayList<Restaurantes> listaRestaurantes;
    private View.OnClickListener listener;

    public ListadoAdapter(ArrayList<Restaurantes> listaRestaurantes) {
        this.listaRestaurantes = listaRestaurantes;
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }
    @Override
    public void onClick(View view) {
        if(listener != null){
            listener.onClick(view);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tRestaurantes, tDescripcion;
        ImageView iImagen;

        public ViewHolder(View itemView) {
            super(itemView);
            tRestaurantes = itemView.findViewById(R.id.tRestaurantes);
            tDescripcion = itemView.findViewById(R.id.tDescripcion);
            iImagen = itemView.findViewById(R.id.iImagen);
        }
    }

    @NonNull
    @Override
    public ListadoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,null,false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListadoAdapter.ViewHolder holder, int position) {
        holder.tRestaurantes.setText(listaRestaurantes.get(position).getRestaurante());
        holder.tDescripcion.setText(listaRestaurantes.get(position).getInfo());
        holder.iImagen.setImageResource(listaRestaurantes.get(position).getFoto());

    }

    @Override
    public int getItemCount() {
        return listaRestaurantes.size();
    }

}