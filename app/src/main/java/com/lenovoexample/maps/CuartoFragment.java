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
public class CuartoFragment extends Fragment implements OnMapReadyCallback {

    private TextView tRestaurante, tDescripcion;
    private ImageView iImagen;
    MapView mapView;
    GoogleMap mMap;

    public CuartoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_uno, container, false);

        mapView = view.findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
        tRestaurante = view.findViewById(R.id.tRestaurante);
        tDescripcion = view.findViewById(R.id.tDescripcion);
        iImagen = view.findViewById(R.id.iImagen);

        tRestaurante.setText("El Corral Los Molinos");
        tDescripcion.setText("Dirección:\n" +
                "   Cl. 31 #81a, Medellín, Antioquia"+
                "\nHorario: \n" +
                "   Lunes 10:00am a 10:00pm\n"+
                "   Martes 10:00am a 10:00pm\n" +
                "   Miércoles 10:00am a 10:00pm\n" +
                "   Jueves 10:00am a 10:00pm\n" +
                "   Viernes 10:00am a 10:00pm\n" +
                "   Sábado 10:00am a 10:00pm\n" +
                "   Domingo 10:00am a 10:00pm\n"
                );
        iImagen.setImageResource(R.drawable.elcorrallosmolinos);

        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng elcorral = new LatLng(6.233442,-75.6037775);
        mMap.addMarker(new MarkerOptions().position(elcorral).title("El Corral Los Molinos").snippet("Restaurante"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(elcorral,15));
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }
}
