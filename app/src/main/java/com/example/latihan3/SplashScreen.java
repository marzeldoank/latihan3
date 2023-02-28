package com.example.latihan3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    private UserModel user;
    private String email = "";
    private String username = "";
    private String password = "";
    private String noHp = "";
    private String alamat = "";
    private Boolean isActive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences inputan = this.getSharedPreferences("applikasi", Context.MODE_PRIVATE);
        email = inputan.getString("email","");
        username = inputan.getString("username","");
        password = inputan.getString("password","");

        user = new UserModel(email, username, password, noHp, alamat, isActive );

        tujuan();

    }
    private void subMainActivity(){
        Intent intent = new Intent(SplashScreen.this, LoginActivity.class);
        startActivity(intent);
    }
    private void subSpalshScreen(){
        Intent intent = new Intent(SplashScreen.this, UserListActivity.class);
        startActivity(intent);
    }
    private void tujuan(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (user.getEmail().equals("")){
                    subMainActivity();
                }else if (user.getPassword().equals("")){
                    subMainActivity();
                }else{
                    subSpalshScreen();
                }
            }
        },3000);
    }
    }
