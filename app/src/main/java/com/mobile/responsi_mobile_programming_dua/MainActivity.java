package com.mobile.responsi_mobile_programming_dua;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Sharedprefmanager sharedprefmanager;
    Handler handler = new Handler();
    EditText namaa,passs;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.signin);
        sharedprefmanager = new Sharedprefmanager(this);
        namaa = findViewById(R.id.nama);
        passs = findViewById(R.id.pass);
        button = findViewById(R.id.btnlogin);
        login();


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this,signup.class);
                startActivity(a);
            }
        });
    }

    private void login() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = namaa.getText().toString();
                final String password = passs.getText().toString();

                button.setVisibility(View.VISIBLE);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        String spuser = sharedprefmanager.getUsername();
                        String sppass = sharedprefmanager.getPassword();
                        Log.d("username","nama"+username);
                        Log.d("password","pass"+password);

                        if (username.equals(spuser)&&password.equals(sppass)){
                            Intent b = new Intent(MainActivity.this,drawer.class);
                            sharedprefmanager.saveIsLogin(true);
                            startActivity(b);
                        }else{
                            button.setVisibility(View.GONE);
                            Toast.makeText(MainActivity.this,"username dan password salah",Toast.LENGTH_SHORT).show();
                        }
                    }
                },3000);
            }
        });
    }
}