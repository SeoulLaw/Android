package com.example.dkdk6.seoullaw.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.dkdk6.seoullaw.R;
import com.tsengvn.typekit.TypekitContextWrapper;

/**
 * Created by dkdk6 on 2017-08-14.
 */
    /*현준아 String id,pw,nickname에 너가 가져가고싶은 정보가 저장되어있으니 구어삶아보렴.*/
public class SignUP_Activity extends AppCompatActivity {
    EditText inputID, inputPW, inputNickname;
    String id, pw, nickname;
    Button signup_comp, signup_can;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        inputID = (EditText) findViewById(R.id.signup_id);
        inputPW = (EditText) findViewById(R.id.signup_pw);
        inputNickname = (EditText) findViewById(R.id.signup_nickname);
        id = inputID.getText().toString();
        pw = inputPW.getText().toString();
        nickname = inputNickname.getText().toString();
        signup_comp =(Button)findViewById(R.id.signup_complete);
        signup_can = (Button)findViewById(R.id.signup_cancel);
        //signup성공시?
        signup_comp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUP_Activity.this, Login_Activity.class);
                startActivity(intent);
                finish();
            }
        });
        signup_can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUP_Activity.this, Login_Activity.class);
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
