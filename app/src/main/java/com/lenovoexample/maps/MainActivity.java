package com.lenovoexample.maps;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.support.v4.app.Fragment;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    private android.support.v4.app.FragmentManager fm;
    private FragmentTransaction ft;
    Bundle bundle = new Bundle();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            fm = getSupportFragmentManager();
            ft = fm.beginTransaction();

            UnoFragment unoFragment = new UnoFragment();
            unoFragment.setArguments(bundle);
            Intent intent = null;
            switch (item.getItemId()) {
                case R.id.mHome:
                    ListadoFragment listado = new ListadoFragment();
                    ft.replace(R.id.frame, listado).commit();
                    return true;
                case R.id.mMap:
                    MapsFragment mapsFragment = new MapsFragment();
                    ft.replace(R.id.frame, mapsFragment).commit();
                    return true;
            }
            return false;

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        ListadoFragment listado = new ListadoFragment();
        ft.replace(R.id.frame, listado).commit();

        UnoFragment unoFragment = new UnoFragment();
        unoFragment.setArguments(bundle);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
}
