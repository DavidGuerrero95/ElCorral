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
public class QuintoFragment extends Fragment implements OnMapReadyCallback {

    private TextView tRestaurante, tDescripcion;
    private ImageView iImagen;
    MapView mapView;
    GoogleMap mMap;


    public QuintoFragment() {
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

        tRestaurante.setText("El Corral El Tesoro");
        tDescripcion.setText("Dirección:\n" +
                "   Cra. 25 #1a-45,C.C El Tesoro, Medellín, Antioquia"+
                "\nHorario: \n" +
                "   Lunes 11:00am a 10:00pm\n"+
                "   Martes 11:00am a 10:00pm\n" +
                "   Miércoles 11:00am a 10:00pm\n" +
                "   Jueves 11:00am a 10:00pm\n" +
                "   Viernes 11:00am a 10:00pm\n" +
                "   Sábado 11:00am a 10:00pm\n" +
                "   Domingo 11:00am a 10:00pm\n" +
                "Teléfono: 317 4348167");
        iImagen.setImageResource(R.drawable.elcorraleltesoro);

        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng elcorral = new LatLng(6.19687,-75.55966);
        mMap.addMarker(new MarkerOptions().position(elcorral).title("El Corral El Tesoro").snippet("Restaurante"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(elcorral,15));
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }
}
