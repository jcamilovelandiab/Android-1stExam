package com.example.myapplication.ui.home.ui.gps;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.R;

import org.w3c.dom.Text;

public class GpsFragment extends Fragment {

    private LocationManager location;
    TextView tv_latitude, tv_longitude;
    Button btn_back, btn_next;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gps, container, false);

        tv_latitude = root.findViewById(R.id.gps_tv_latitude);
        tv_longitude = root.findViewById(R.id.gps_tv_longitude);
        btn_back = root.findViewById(R.id.gps_btn_back);
        btn_next = root.findViewById(R.id.gps_btn_next);

        locate();

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().popBackStack();
            }
        });

        return root;
    }

    private void locate() {
        if (ActivityCompat.checkSelfPermission(this.getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this.getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    Activity#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for Activity#requestPermissions for more details.
            ActivityCompat.requestPermissions(this.getActivity(), new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION
            }, 1000);
        }
        location = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        Location loc = location.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        if(location != null){
            String latitude = String.valueOf(loc.getLatitude());
            String longitude = String.valueOf(loc.getLongitude());
            tv_latitude.setText("Latitude: "+latitude);
            tv_longitude.setText("Longitude: "+longitude);
        }
    }
}