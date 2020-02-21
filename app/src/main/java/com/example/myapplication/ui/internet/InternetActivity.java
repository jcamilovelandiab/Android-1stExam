package com.example.myapplication.ui.internet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

import com.example.myapplication.R;
import com.example.myapplication.ui.camera.CameraActivity;
import com.example.myapplication.ui.gps.GpsActivity;

public class InternetActivity extends AppCompatActivity {

    WebView buscador;
    String url = "https://www.google.com";
    Button btn_back, btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internet);

        buscador = (WebView) findViewById(R.id.internet_web);

        final WebSettings ajustesVisorWeb = buscador.getSettings();
        ajustesVisorWeb.setJavaScriptEnabled(true);

        buscador.loadUrl(url);

        btn_back = findViewById(R.id.internet_btn_back);
        btn_next = findViewById(R.id.internet_btn_next);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InternetActivity.this, GpsActivity.class);
                startActivity(intent);
            }
        });

    }
}
