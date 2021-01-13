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

public class signup extends AppCompatActivity {
    EditText nama11, pass11;
    Button loginn;
    Sharedprefmanager sharedprefmanager;
    Handler handler = new Handler();
    TextView signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        signin = findViewById(R.id.signup);
        sharedprefmanager = new Sharedprefmanager(this);
        nama11 = findViewById(R.id.nama1);
        pass11 = findViewById(R.id.pass1);
        loginn = findViewById(R.id.loginn2);
        login();
    }

    private void login() {
        loginn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = nama11.getText().toString();
                final String password = pass11.getText().toString();

                loginn.setVisibility(View.VISIBLE);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        String spuser = sharedprefmanager.getUsername();
                        String sppass = sharedprefmanager.getPassword();
                        Log.d("username", "nama" + username);
                        Log.d("password", "pass" + password);

                        if (username.equals(spuser) && password.equals(sppass)) {
                            Intent b = new Intent(signup.this, drawer.class);
                            sharedprefmanager.saveIsLogin(true);
                            finishAffinity();
                            startActivity(b);
                        } else {
                            loginn.setVisibility(View.GONE);
                            Toast.makeText(signup.this, "username dan password salah", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, 3000);
            }
        });
    }
}