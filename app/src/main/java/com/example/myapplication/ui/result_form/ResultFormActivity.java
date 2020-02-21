package com.example.myapplication.ui.result_form;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.data.UserRepository;
import com.example.myapplication.data.model.Gender;
import com.example.myapplication.data.model.LoggedInUser;
import com.example.myapplication.data.model.Token;
import com.example.myapplication.data.model.User;
import com.example.myapplication.ui.menu.MenuActivity;

public class ResultFormActivity extends AppCompatActivity {

    TextView tv_name, tv_phone, tv_home_country, tv_gender, tv_age;
    Button btn_back, btn_next;

    UserRepository userRepository = UserRepository.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_form);

        tv_name = findViewById(R.id.result_form_tv_name);
        tv_phone = findViewById(R.id.result_form_tv_phone);
        tv_home_country = findViewById(R.id.result_form_tv_home_country);
        tv_gender = findViewById(R.id.result_form_tv_gender);
        tv_age = findViewById(R.id.result_form_tv_age);

        btn_back = findViewById(R.id.result_form_btn_back);
        btn_next = findViewById(R.id.result_form_btn_next);

        String strName="", strPhone="", strCountry="", strGender = "";
        Bundle bundle = this.getIntent().getExtras();
        if(bundle !=null){

            strName = bundle.getString("name", "unnamed");
            strPhone = bundle.getString("phone", "without phone");
            strCountry = bundle.getString("home_country", "without country");
            strGender = bundle.getString("gender", "UNKNOWN");

            tv_name.setText("Name: "+strName);
            tv_phone.setText("Phone: "+strPhone);
            tv_home_country.setText("Home country: "+strCountry);
            tv_gender.setText("Gender: "+strGender);

            if(!strName.equals("unnamed")){
                User user = new User(null,null, strName, strPhone, strCountry, Gender.valueOf(strGender));
                btn_next.setEnabled(true);
                configureBtnNext(user);
            }else{
                btn_next.setEnabled(false);
            }
        }else{
            btn_next.setEnabled(false);
        }
        configureBtnBack();
    }

    private void configureBtnNext(final User user){
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateUiWithUser(user.getName());
            }
        });
    }

    private void updateUiWithUser(String name) {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
        String welcome = getString(R.string.welcome) + name+" !";
        // TODO : initiate successful logged in experience
        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
    }

    private void configureBtnBack(){
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
