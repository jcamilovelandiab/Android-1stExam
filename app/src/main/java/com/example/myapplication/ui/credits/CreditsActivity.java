package com.example.myapplication.ui.credits;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;
import com.example.myapplication.ui.camera.CameraActivity;
import com.example.myapplication.ui.internet.InternetActivity;
import com.example.myapplication.ui.menu.MenuActivity;

public class CreditsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits2);

        Button btn_back = findViewById(R.id.credits_btn_back);
        Button btn_next = findViewById(R.id.credits_btn_next);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreditsActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

    }
}
