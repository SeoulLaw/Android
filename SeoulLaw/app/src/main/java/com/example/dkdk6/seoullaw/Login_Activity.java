package com.example.dkdk6.seoullaw;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.tsengvn.typekit.TypekitContextWrapper;

import org.w3c.dom.Text;

/**
 * Created by dkdk6 on 2017-08-14.
 */

public class Login_Activity extends AppCompatActivity {
    String address = "http://192.168.1.8:3000/login";
    EditText inputID, inputPW;
    String id, pw;
    TextView signupBtn;
    Button login;

    /*현준아 String id,pw에 너가 가져가고싶은 정보가 저장되어있으니 구어삶아보렴.*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        signupBtn = (TextView) findViewById(R.id.login_signupBtn);
        login = (Button) findViewById(R.id.login_loginBtn);
        signupBtn.setText(Html.fromHtml("<u>" + "회원가입 바로가기" + "<u>"));
        login.setText("로그인");
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginintent = new Intent(Login_Activity.this, SignUP_Activity.class);
                startActivity(loginintent);
            }
        });
        inputID = (EditText) findViewById(R.id.login_id);
        inputPW = (EditText) findViewById(R.id.login_pw);
        id = inputID.getText().toString();
        pw = inputPW.getText().toString();
        login = (Button) findViewById(R.id.login_loginBtn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_Activity.this, Main_Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected void attachBaseContext(Context newBase) {

        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));

    }

}
