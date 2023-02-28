package com.example.latihan3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    private TextView tvHomeEmail, tvHomeUsername, tvHomePassword;
    private Button btnLogout;
    private String email, username,password, noHp, alamat;
    private Boolean isActive;
    private UserModel user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initWidget();
        initAction();
        data();
    }
    private void initWidget(){
        tvHomeEmail = findViewById(R.id.tv_home_email);
        tvHomeUsername = findViewById(R.id.tv_home_username);
        tvHomePassword = findViewById(R.id.tv_home_password);
        btnLogout = findViewById(R.id.btn_logout);
    }
    private void initAction(){
        btnLogout.setOnClickListener(view -> {
            kembali();

        });

    }
    private void data(){
        SharedPreferences inputan = this.getSharedPreferences("applikasi", Context.MODE_PRIVATE);
        email = inputan.getString("email","");
        username = inputan.getString("username","");
        password = inputan.getString("password","");

        user = new UserModel(email,username,password, noHp, alamat, isActive);

        tvHomeEmail.setText(email);
        tvHomeUsername.setText(username);
        tvHomePassword.setText(password);
    }
    private void kembali(){
        SharedPreferences inputan = this.getSharedPreferences("applikasi", Context.MODE_PRIVATE);
            inputan.edit().clear().apply();
//        inputan.edit().remove("username").apply();

        Intent intent = new Intent(HomeActivity.this,LoginActivity.class);
        startActivity(intent);
    }
}