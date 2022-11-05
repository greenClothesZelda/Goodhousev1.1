package com.example.goodhouse;

import android.app.Application;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Button btnLogin;
    TextView id, token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin = (Button) findViewById(R.id.loginButton);
        id = (TextView) findViewById(R.id.loginId);
        token = (TextView) findViewById(R.id.loginPassword);

        View.OnClickListener loginEvent = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idString = id.getText().toString();
                String tokenString = token.getText().toString();
                LoginData loginData = new LoginData(idString, tokenString);
                boolean loginResult = loginData.sendLoginData();
                if(loginResult) {
                    //다음화면 전환
                    Intent intent = new Intent(MainActivity.this, MainPageActivity.class);
                    startActivity(intent);
                } else{
                    Toast.makeText(getApplicationContext(), "아이디 혹은 토큰값이 올바르지 않습니다.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        };
        btnLogin.setOnClickListener(loginEvent);

    }
}
class LoginData{
    String id = "";
    String token = "";

    LoginData(String id, String token){
        this.id = id;
        this.token = token;
    }

    boolean sendLoginData(){ //미구현 부분 임시아이디와 토큰으로 구현
        if(id.equals("1")&&token.equals("1")) return true;
        else return false;
    }

}