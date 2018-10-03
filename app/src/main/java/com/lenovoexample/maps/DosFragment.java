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
public class DosFragment extends Fragment implements OnMapReadyCallback {

    private TextView tRestaurante, tDescripcion;
    private ImageView iImagen;
    MapView mapView;
    GoogleMap mMap;


    public DosFragment() {
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

        tRestaurante.setText("El Corral Oviedo");
        tDescripcion.setText("Dirección:\n" +
                "Carrera 43 A No. 6 Sur - 15 Local 172 C.C. Oviedo, El Poblado #65-15, Medellín, Antioquia"+
                "\nHorario: \n" +
                "   Lunes 11:30am a 10:30pm\n"+
                "   Martes 11:30am a 10:30pm\n" +
                "   Miércoles 11:30am a 10:30pm\n" +
                "   Jueves 11:30am a 11:00pm\n" +
                "   Viernes 11:30am a 12:00am\n" +
                "   Sábado 11:30am a 12:00am\n" +
                "   Domingo 11:30am a 10:30pm\n" +
                "Teléfono: (4) 3139068");
        iImagen.setImageResource(R.drawable.elcorraloviedo);

        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng elcorral = new LatLng(6.1989082,-75.5739611);
        mMap.addMarker(new MarkerOptions().position(elcorral).title("El Corral Oviedo").snippet("Restaurante"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(elcorral,15));
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }
}
