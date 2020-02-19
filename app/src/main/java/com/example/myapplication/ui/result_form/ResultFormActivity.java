package com.example.myapplication.ui.result_form;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.data.UserRepository;
import com.example.myapplication.data.model.Gender;
import com.example.myapplication.data.model.LoggedInUser;
import com.example.myapplication.data.model.User;
import com.example.myapplication.ui.home.MainActivity;
import com.example.myapplication.ui.signup.SignupActivity;

public class ResultFormActivity extends AppCompatActivity {

    TextView tv_name, tv_phone, tv_home_country, tv_gender, tv_age, tv_email, tv_password;
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
        tv_email = findViewById(R.id.result_form_tv_email);

        btn_back = findViewById(R.id.result_form_btn_back);
        btn_next = findViewById(R.id.result_form_btn_next);

        String strName="", strPhone="", strEmail="", strPassword="", strCountry="", strGender = "";
        Bundle bundle = this.getIntent().getExtras();
        if(bundle !=null){

            strName = bundle.getString("name", "unnamed");
            strPhone = bundle.getString("phone", "without phone");
            strCountry = bundle.getString("home_country", "without country");
            strGender = bundle.getString("gender", "UNKNOWN");
            strEmail = bundle.getString("email", "without email");
            strPassword = bundle.getString("password", "without password");
            tv_name.setText("Name: "+strName);
            tv_phone.setText("Phone: "+strPhone);
            tv_home_country.setText("Home country: "+strCountry);
            tv_gender.setText("Gender: "+strGender);
            tv_email.setText("Email: "+strEmail);
            //tv_password.setText("Password: "+strPassword);

            if(!strEmail.equals("without email") && !strPassword.equals("without password")
                    && !strName.equals("unnamed")){
                User user = new User(strEmail,strPassword, strName, strPhone, strCountry, Gender.valueOf(strGender));
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
                LoggedInUser result = userRepository.signup(user);
                if(result!=null){
                    updateUiWithUser(result);
                    setResult(Activity.RESULT_OK);
                    finish();
                }else{
                    Toast.makeText(ResultFormActivity.this,
                            "The entered mail is already associated with an existing account! Please change your email", Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });
    }

    private void updateUiWithUser(LoggedInUser model) {
        SharedPreferences.Editor sharedPref =
                getSharedPreferences( getString( R.string.preference_file_key), Context.MODE_PRIVATE ).edit();
        sharedPref.putString("TOKEN_KEY", model.getToken().getAccessToken());

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        String welcome = getString(R.string.welcome) + model.getEmail()+" !";
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
