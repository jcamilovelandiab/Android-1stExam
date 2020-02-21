package com.example.myapplication.ui.form;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.ui.result_form.ResultFormActivity;
import com.example.myapplication.data.model.Gender;

public class FormActivity extends AppCompatActivity {

    Spinner sp_home_country;
    Button btn_clean, btn_next;
    EditText et_name, et_phone;
    RadioGroup rbg_gender_group;
    Button rb_male, rb_female;
    Gender gender = Gender.UNKNOWN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        et_name = findViewById(R.id.signup_et_name);
        et_phone = findViewById(R.id.signup_et_phone);

        sp_home_country = findViewById(R.id.signup_sp_home_country);
        configureSpinnerHomeCountry();

        rbg_gender_group = findViewById(R.id.signup_rbg_gender_group);
        rb_male = findViewById(R.id.signup_rb_male);
        rb_female = findViewById(R.id.signup_rb_female);
        configureRbMale(); configureRbFemale();

        btn_next = findViewById(R.id.signup_btn_next);
        configureBtnNext();

        btn_clean = findViewById(R.id.signup_btn_clean);
        configureBtnClean();
    }


    private void configureSpinnerHomeCountry(){
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.countries_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        sp_home_country.setAdapter(adapter);
        sp_home_country.setOnItemSelectedListener(new CountryOnItemSelectedListener());
    }

    private void configureRbMale() {
        rb_male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gender = Gender.MALE;
            }
        });
    }

    private void configureRbFemale(){
        rb_female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gender = Gender.FEMALE;
            }
        });
    }

    private void configureBtnNext(){
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strName, strPhone, strCountry;
                strName = et_name.getText().toString();
                strPhone = et_phone.getText().toString();
                strCountry = sp_home_country.getSelectedItem().toString();

                if(strName.trim().equals("") || strPhone.trim().equals("") ||
                    strCountry.trim().equals("") || gender.equals(Gender.UNKNOWN)){
                    Toast.makeText(FormActivity.this, "Please, fill in the entire form correctly", Toast.LENGTH_LONG).show();
                }else{
                    Intent intent = new Intent(view.getContext(), ResultFormActivity.class);

                    intent.putExtra("name", strName);
                    intent.putExtra("phone", strPhone);
                    intent.putExtra("home_country", strCountry);
                    intent.putExtra("gender",gender.toString());

                    startActivity(intent);
                }
            }
        });
    }

    private void configureBtnClean(){
        btn_clean.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                et_name.setText("");
                et_phone.setText("");
            }
        });
    }

}
