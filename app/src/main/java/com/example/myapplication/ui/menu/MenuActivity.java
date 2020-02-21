package com.example.myapplication.ui.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.ui.LaunchActivity;
import com.example.myapplication.ui.credits.CreditsActivity;
import com.example.myapplication.R;
import com.example.myapplication.ui.camera.CameraActivity;
import com.example.myapplication.ui.gallery.GalleryActivity;
import com.example.myapplication.ui.gps.GpsActivity;
import com.example.myapplication.ui.internet.InternetActivity;
import com.example.myapplication.ui.login.LoginActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button btn_camera = findViewById(R.id.menu_btn_camera);
        final Button btn_gallery = findViewById(R.id.menu_btn_gallery);
        Button btn_internet = findViewById(R.id.menu_btn_internet);
        Button btn_gps = findViewById(R.id.menu_btn_gps);
        Button btn_credits = findViewById(R.id.menu_btn_credits);
        Button btn_exit = findViewById(R.id.menu_btn_exit);
        Button btn_back = findViewById(R.id.menu_btn_back);

        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, CameraActivity.class);
                startActivity(intent);
            }
        });
        btn_gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, GalleryActivity.class);
                startActivity(intent);
            }
        });
        btn_internet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, InternetActivity.class);
                startActivity(intent);
            }
        });
        btn_gps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, GpsActivity.class);
                startActivity(intent);
            }
        });
        btn_credits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, CreditsActivity.class);
                startActivity(intent);
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btn_exit.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View view){
               Intent intent = new Intent(MenuActivity.this, LaunchActivity.class);
               intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
               intent.putExtra("SHOULD_FINISH", true);
               startActivity(intent);
               Toast toast = Toast.makeText(view.getContext(), "Bye!!. Hope to see you soon!", Toast.LENGTH_LONG);
               toast.show();
               finish();
           }
        });

    }

}
