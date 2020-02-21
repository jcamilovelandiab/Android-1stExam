package com.example.myapplication.ui.gps;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.myapplication.R;
import com.example.myapplication.ui.camera.CameraActivity;
import com.example.myapplication.ui.credits.CreditsActivity;
import com.example.myapplication.ui.internet.InternetActivity;

public class GpsActivity extends AppCompatActivity {

    private LocationManager location;
    TextView tv_latitude, tv_longitude;
    Button btn_back, btn_next, btn_see_map;
    Double double_latitude, double_longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);

        tv_latitude = findViewById(R.id.gps_tv_latitude);
        tv_longitude = findViewById(R.id.gps_tv_longitude);
        btn_back = findViewById(R.id.gps_btn_back);
        btn_next = findViewById(R.id.gps_btn_next);
        btn_see_map = findViewById(R.id.gps_btn_see_map);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GpsActivity.this, CreditsActivity.class);
                startActivity(intent);
            }
        });
        btn_see_map.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(GpsActivity.this, MapsActivity.class);
               intent.putExtra("latitude", double_latitude);
               intent.putExtra("longitude", double_longitude);
               startActivity(intent);
           }
       });

        locate();
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void locate() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    Activity#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for Activity#requestPermissions for more details.
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION
            }, 1000);
        }
        location = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Location loc = location.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        if(location != null){
            String latitude = String.valueOf(loc.getLatitude());
            String longitude = String.valueOf(loc.getLongitude());
            double_latitude = Double.parseDouble(latitude);
            double_longitude = Double.parseDouble(longitude);
            tv_latitude.setText("Latitude: "+latitude);
            tv_longitude.setText("Longitude: "+longitude);
        }

    }

}
