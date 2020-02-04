package com.example.subscriptionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {


    Button button;
    EditText nameEditText;
    EditText emailEditText;
    EditText phoneEditText;
    RadioGroup genderRadioGroup;
    Client client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeUIComponent();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFormInformation();
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                intent.putExtra("NAME", client.getName());
                intent.putExtra("EMAIL", client.getEmail());
                intent.putExtra("PHONE", client.getPhoneNumber());
                intent.putExtra("GENDER", client.isGender());
                startActivity(intent);
            }
        });

    }

    private void initializeUIComponent() {
        button = findViewById(R.id.btn_subscribe_me);
        nameEditText = findViewById(R.id.input_name);
        emailEditText = findViewById(R.id.input_email);
        phoneEditText = findViewById(R.id.input_phone_number);
        genderRadioGroup = findViewById(R.id.rg_gender);

    }

    private void getFormInformation() {
        client = new Client();
        client.setName(nameEditText.getText().toString());
        client.setEmail(emailEditText.getText().toString());
        client.setPhoneNumber(phoneEditText.getText().toString());
        genderRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.male) {
                    client.setGender(true);
                } else {
                    client.setGender(false);
                }
            }
        });
    }

}
