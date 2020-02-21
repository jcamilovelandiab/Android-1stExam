package com.example.myapplication.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.ui.login.LoginActivity;

public class LaunchActivity extends AppCompatActivity {

    public static final String TOKEN_KEY = "TOKEN_KEY";

    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);

        if (getIntent().getBooleanExtra("SHOULD_FINISH", false)) {
            finish();
        }else{
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

    }

}