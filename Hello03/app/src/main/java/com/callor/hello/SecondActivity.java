package com.callor.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView txt_join = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txt_join = findViewById(R.id.txt_join);

        Intent intent = getIntent();
        String userId = intent.getExtras().getString("ID");
        String userPw = intent.getExtras().getString("Password");
        String userName = intent.getExtras().getString("Name");
        String userTel = intent.getExtras().getString("TEL");
        String userAddr = intent.getExtras().getString("Address");

        String msg = String.format("ID : %s \nPW : %s \nName : %s \nTEL : %s\nAddress : %s",userId,userPw,userName,userTel,userAddr);

        txt_join.setText(msg);

    }
}