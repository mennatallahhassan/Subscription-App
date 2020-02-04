package com.example.subscriptionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Client client = new Client();
        Intent intent = getIntent();
        client.setName(intent.getStringExtra("NAME"));
        client.setEmail(intent.getStringExtra("EMAIL"));
        client.setGender(intent.getBooleanExtra("GENDER", true));

        TextView bodyTextView = findViewById(R.id.textview_body);

        if (client.isGender() == true){
            //MALE
            bodyTextView.setText(bodyTextView.getText().toString().replace("REPLACE_0", "Mr."));
        }else {
            //FEMALE
            bodyTextView.setText(bodyTextView.getText().toString().replace("REPLACE_0", "Ms."));

        }
        bodyTextView.setText(bodyTextView.getText().toString().replace("REPLACE_1", client.getName()));
        bodyTextView.setText(bodyTextView.getText().toString().replace("REPLACE_2", client.getEmail()));
    }
}
