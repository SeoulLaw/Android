package com.example.dkdk6.seoullaw.Activity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dkdk6.seoullaw.R;
import com.tsengvn.typekit.TypekitContextWrapper;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URL;

/**
 * Created by dkdk6 on 2017-08-14.
 */

public class Login_Activity extends AppCompatActivity {
    String address = "http://192.168.1.8:3000/login/?";
    EditText inputID, inputPW;
    String receive;
    String query;
    TextView signupBtn;
    Button login;
    String singupFlag = "false";

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
        login = (Button) findViewById(R.id.login_loginBtn);
        /*
        localhost:3000/login/?id=chj878194&pw=chj1234&sign_up=false
         */
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_Activity.this, Main_Activity.class);
                startActivity(intent);
                finish();
/*                query = address + "id=" + inputID.getText().toString() + "&" + "pw=" + inputPW.getText().toString() + "&" + "sign_up=" + singupFlag;
                final NetworkTask networkTask = new NetworkTask(query, null);
                networkTask.execute();
                //receive = networkTask.doInBackground();
                //  Log.d("Rec",receive);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            JSONObject jsonObject = new JSONObject(receive);
                            String result = jsonObject.getString("response");
                            Log.d("Rece", result);
                            if (result.equals("success")) {
                                Log.d("Rece", "성공");
                                Intent intent = new Intent(Login_Activity.this, Main_Activity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(getApplicationContext(), "아이디 또는 비밀번호를 다시 입력하세요!", Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, 500);*/
            }
        });

    }

    public class NetworkTask extends AsyncTask<Void, Void, String> {

        private String url;
        private ContentValues values;

        public NetworkTask(String url, ContentValues values) {

            this.url = url;
            this.values = values;

        }

        @Override
        protected String doInBackground(Void... params) {

           /* String result; // 요청 결과를 저장할 변수.
            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
            result = requestHttpURLConnection.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.

            return result;*/
            try {
                URL url = new URL(query);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection(); // URL을 연결한 객체 생성.
                conn.setRequestMethod("GET"); // get방식 통신
                conn.setDoOutput(true); // 쓰기모드 지정
                conn.setDoInput(true); // 읽기모드 지정
                conn.setUseCaches(false); // 캐싱데이터를 받을지 안받을지
                conn.setDefaultUseCaches(false); // 캐싱데이터 디폴트 값 설정
                conn.setConnectTimeout(3 * 1000);
                conn.setReadTimeout(3 * 1000);
                InputStream is = conn.getInputStream(); //input스트림 개방
                StringBuilder builder = new StringBuilder(); //문자열을 담기 위한 객체
                BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8")); //문자열 셋 세팅
                String line;

                while ((line = reader.readLine()) != null) {
                    builder.append(line + "\n");
                }

                receive = builder.toString();
                Log.d("Rece", receive);

            } catch (MalformedURLException | ProtocolException exception) {
                exception.printStackTrace();
            } catch (IOException io) {
                io.printStackTrace();
            }
            return null;

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            //doInBackground()로 부터 리턴된 값이 onPostExecute()의 매개변수로 넘어오므로 s를 출력한다.

        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {

        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));

    }

}
