package com.lenovoexample.maps;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class UnoFragment extends Fragment implements OnMapReadyCallback{

    private TextView tRestaurante, tDescripcion;
    private ImageView iImagen;
    MapView mapView;
    GoogleMap mMap;

    public UnoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_uno, container, false);

        mapView = view.findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
        tRestaurante = view.findViewById(R.id.tRestaurante);
        tDescripcion = view.findViewById(R.id.tDescripcion);
        iImagen = view.findViewById(R.id.iImagen);

        tRestaurante.setText("El Corral Santa Fe");
        tDescripcion.setText("Dirección: \n   Local 4317 C.C. Santa Fe, El Poblado #7 Sur 170, Medellín, Antioquia"+
                "\nHorario: \n" +
                "   lunes\t12:00a21:00\n" +
                "   martes\t12:00a21:00\n" +
                "   miércoles\t12:00a21:00\n" +
                "   jueves\t12:00a21:00\n" +
                "   viernes\t12:00a21:00\n" +
                "   sábado\t12:00a22:00\n" +
                "   domingo\t12:00a21:00\n" +
                "Teléfono: (4) 3132164");
        iImagen.setImageResource(R.drawable.elcorralsantafe);

        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng elcorral = new LatLng(6.196852,-75.5743513);
        mMap.addMarker(new MarkerOptions().position(elcorral).title("El Corral Santa Fe").snippet("Restaurante"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(elcorral,15));
    }
    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }
}
