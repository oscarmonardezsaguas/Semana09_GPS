package com.example.semana09_gps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   private LocationManager ubicacion;
   TextView longitud, latitud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        localizacion();
    }

    private void localizacion(){
    if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION
        }, 1000);
    }
    longitud     = findViewById(R.id.tvLongitud);
    latitud = findViewById(R.id.tvLatitud);

    LocationManager ubicacion = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
    Location loc = ubicacion.getLastKnownLocation(LocationManager.GPS_PROVIDER);

    Log.d("Longitud", String.valueOf(loc.getLongitude()));
    Log.d("Latitud", String.valueOf(loc.getLatitude()));

    longitud.setText("Longitud:" + String.valueOf(loc.getLongitude()));
    latitud.setText("Latitud:"+ String.valueOf(loc.getLatitude()));
}

}