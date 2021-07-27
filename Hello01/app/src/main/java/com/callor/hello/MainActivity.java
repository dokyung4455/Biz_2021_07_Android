package com.callor.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.callor.hello.ui.login.LoginActivity;
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

    private Button btn_next = null;
    private Button btn_login = null;
    private Button btn_phone = null;


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
        btn_next = findViewById(R.id.btn_next);
        btn_login = findViewById(R.id.btn_login);
        btn_phone = findViewById(R.id.btn_phone);


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

        // click event 를 처리할 event Handler 를 선언하기
        // interface 를 사용하여 직접 객체를 생성하는 방법
        // 정통 java 에서는 interface 를  implements 한 클래스를 작성하고
        // 클래스를 사용하여 객체를 선언(생성, 초기화) 하였는데 interface 를 직접 객체를 사용하는 용도로 활용
        View.OnClickListener btn_click = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.btn_login) {
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);

                } else if(v.getId() == R.id.btn_next) {
                    /*
                    Intent(인텐트)
                    Android 에서 Activity 를 부르는 다른 이름
                    Activity 의 super parent interface 이다.

                    새로운 Activity 를 보여주는 절차
                    1. Intent 클래스를 사용하여 인텐트 생성
                    2. startActivity() method 호출하여 새로운 Activity 로  화면전환

                    startActivity() 는 이미 준비된 method
                     */
                    Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                    startActivity(intent);

                } else if(v.getId() == R.id.btn_phone) {
                    String num = edit_01.getText().toString();
                    num = "tel:" + num;

                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(num));
                    startActivity(intent);
                }


                }
        };
        // 하나의 event handler 를 생성하여
        // 2개의 버튼에 동시에 적용하기
        btn_next.setOnClickListener(btn_click);
        btn_login.setOnClickListener(btn_click);
        btn_phone.setOnClickListener(btn_click);



    }
}