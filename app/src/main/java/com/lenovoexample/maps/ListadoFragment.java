package com.lenovoexample.maps;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListadoFragment extends Fragment {

    ArrayList<Restaurantes> listaRestaurantes;
    RecyclerView recyclerView;
    private android.support.v4.app.FragmentManager fm;
    private FragmentTransaction ft;


    public ListadoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_listado, container, false);

        final FragmentTransaction transaction = getFragmentManager().beginTransaction();

        listaRestaurantes = new ArrayList<>();
        recyclerView = view.findViewById(R.id.recyclerId);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        llenarRestaurantes();

        ListadoAdapter listadoAdapter = new ListadoAdapter(listaRestaurantes);

        listadoAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listaRestaurantes.get(recyclerView.getChildAdapterPosition(v)).getRestaurante().equals("El corral Santa fe")){
                    Toast.makeText(getContext(),"Seleccion: "+ listaRestaurantes.get(recyclerView.getChildAdapterPosition(v)).getRestaurante(),Toast.LENGTH_LONG).show();
                    transaction.replace(R.id.frame,new UnoFragment());
                    transaction.addToBackStack(null);
                    transaction.commit();
                }else if(listaRestaurantes.get(recyclerView.getChildAdapterPosition(v)).getRestaurante().equals("El corral Oviedo")){
                    Toast.makeText(getContext(),"Seleccion: "+ listaRestaurantes.get(recyclerView.getChildAdapterPosition(v)).getRestaurante(),Toast.LENGTH_LONG).show();
                    transaction.replace(R.id.frame,new DosFragment());
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
                else if(listaRestaurantes.get(recyclerView.getChildAdapterPosition(v)).getRestaurante().equals("El corral Laureles")){
                    Toast.makeText(getContext(),"Seleccion: "+ listaRestaurantes.get(recyclerView.getChildAdapterPosition(v)).getRestaurante(),Toast.LENGTH_LONG).show();
                    transaction.replace(R.id.frame,new TercerFragment());
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
                else if(listaRestaurantes.get(recyclerView.getChildAdapterPosition(v)).getRestaurante().equals("El corral Los Molinos")){
                    Toast.makeText(getContext(),"Seleccion: "+ listaRestaurantes.get(recyclerView.getChildAdapterPosition(v)).getRestaurante(),Toast.LENGTH_LONG).show();
                    transaction.replace(R.id.frame,new CuartoFragment());
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
                else if(listaRestaurantes.get(recyclerView.getChildAdapterPosition(v)).getRestaurante().equals("El corral El Tesoro")){
                    Toast.makeText(getContext(),"Seleccion: "+ listaRestaurantes.get(recyclerView.getChildAdapterPosition(v)).getRestaurante(),Toast.LENGTH_LONG).show();
                    transaction.replace(R.id.frame,new QuintoFragment());
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            }
        });
        recyclerView.setAdapter(listadoAdapter);
        return view;
    }

    private void llenarRestaurantes() {
        listaRestaurantes.add(new Restaurantes("El corral Santa fe","Dirección: #7a 177 a 251, Cra. 42 #7a Sur, Medellín, Antioquia",R.drawable.elcorralsantafe));
        listaRestaurantes.add(new Restaurantes("El corral Oviedo","Dirección: Calle 6S #43A-127, Medellín, Antioquia",R.drawable.elcorraloviedo));
        listaRestaurantes.add(new Restaurantes("El corral Laureles","Dirección: Av. Nutibara #74-9, Medellín, Antioquia",R.drawable.elcorrallaureles));
        listaRestaurantes.add(new Restaurantes("El corral Los Molinos","Dirección: Cl. 31 #81a, Medellín, Antioquia",R.drawable.elcorrallosmolinos));
        listaRestaurantes.add(new Restaurantes("El corral El Tesoro","Dirección: Local 3580, Cra. 29 #1 A Sur, Medellín, Antioquia",R.drawable.elcorraleltesoro));
    }

}
