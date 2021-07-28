package com.callor.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Button;

import com.callor.hello.model.UserDTO;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText us_id = null;
    private TextInputEditText us_pw = null;
    private TextInputEditText us_name = null;
    private TextInputEditText us_tel = null;
    private TextInputEditText us_addres = null;
    private Button btn_join = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        us_id=findViewById(R.id.txt_id);
        us_pw=findViewById(R.id.txt_pw);
        us_name=findViewById(R.id.txt_name);
        us_tel=findViewById(R.id.txt_tel);
        us_addres=findViewById(R.id.txt_address);

        btn_join=findViewById(R.id.btn_join);

        btn_join.setOnClickListener((view)-> {

            String userId = us_id.getText().toString();
            String userPw = us_pw.getText().toString();
            String userName = us_name.getText().toString();
            String userTel = us_tel.getText().toString();
            String userAddr = us_addres.getText().toString();

//            UserDTO user = new UserDTO();
//            user.user_id = userId;
//            user.password = userPw;
//            user.name = userName;
//            user.tel = userTel;
//            user.addr = userAddr;

            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            //intent.putExtra("USER", (Parcelable) user);
            intent.putExtra("ID",userId);
            intent.putExtra("Password",userPw);
            intent.putExtra("Name",userName);
            intent.putExtra("TEL",userTel);
            intent.putExtra("Address",userAddr);
            startActivity(intent);

        });








    }
}