package com.example.myapplication.ui.camera;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.myapplication.R;
import com.example.myapplication.ui.internet.InternetActivity;

public class CameraActivity extends AppCompatActivity {

    private Button btn_take_picture;
    private ImageView iv_picture;
    private Button btn_back, btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        btn_back = findViewById(R.id.camera_btn_back);
        btn_next = findViewById(R.id.camera_btn_next);
        btn_take_picture = findViewById(R.id.camera_btn_take_picture);
        iv_picture = findViewById(R.id.camera_iv_picture);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CameraActivity.this, InternetActivity.class);
                startActivity(intent);
            }
        });

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{
                            Manifest.permission.CAMERA
                    }, 1000);
        }

        btn_take_picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 100);
            }
        });
    }

    @Override
    protected  void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        if(requestCode==100){
            Bitmap captureImage = (Bitmap) data.getExtras().get("data");
            iv_picture.setImageBitmap(captureImage);
        }
    }

}
