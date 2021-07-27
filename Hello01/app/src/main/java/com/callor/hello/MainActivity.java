package com.callor.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

/*
Activity.class 가 하는일
1. 화면에 UI를 포현하는 일
    *.xml 파일을 읽어서 화면을 구현한다.
    event Handling 수행
2. Activity 이름 짓는 방법
    Activity 클래스는 UI 관련된 파일을 1개 이상 연결한다.
    {이름}Activity.java 형식으로 작성하고 (ex: MainActivity.java)
    activity_{이름}.xml 형식으로 화면 구현 xml 파일을 작성한다. (ex: activity_main.xml)

 */
public class MainActivity extends AppCompatActivity {

    private TextView txt1 = null;
    private TextView txt2 = null;
    private EditText edit_01 = null;


    /*
    onCreate 형식의 method 란?
    on{...} Method 는 대체로 event Handler 들이다.
    Create 동작이 실행될때 같이 동반하여 작동되는 Method
    작성하고 있는 App 이 안드로이드 phone 에서 생성될때 작동하는 method

    안드로이드 App 에서는 onCreate()를 진입점 method 로 취급한다.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
        res -> layout -> activity_main.xml 파일을 읽어서(열어서)
        시작화면(현재 클래스가 작동되는 화면)을 만들어라
         */

        /*
        xml view 에 설정된 view content 를 java code 에서 사용하기 위해 import 하는 절차
         */
        setContentView(R.layout.activity_main);

        txt1 = findViewById(R.id.txt_01);
        txt2 = findViewById(R.id.txt_02);


        txt1.setText("다시 반갑습니다.");
        txt2.setText("최건진(도경) 입니다.");


        edit_01 = findViewById(R.id.edit_01);


        txt2.setOnClickListener((view)->{
            String txt = edit_01.getText().toString();
            txt = "입력한 전화번호 " + txt;
            Toast.makeText(this,txt,Toast.LENGTH_LONG).show();
        });

        txt1.setOnClickListener((view)-> {
            String str = edit_01.getText().toString();
            String msg = String.format("입력한 번호 : %s", str);
            Snackbar.make(view,str, Snackbar.LENGTH_LONG).show();
        });



    }
}