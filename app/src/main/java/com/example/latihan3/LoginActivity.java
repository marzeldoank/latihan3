package com.example.latihan3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private ImageView ivlogo;
    private EditText etEmail,etUsername,etPassword;
    private Button btConfrim;
    private TextView tvEmail,tvUsername,tvPassword;
    private String email, userName, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initWidget();
        initAction();
    }
    private void initWidget(){
        ivlogo = findViewById(R.id.iv_logo);
        etEmail = findViewById(R.id.et_email);
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btConfrim = findViewById(R.id.bt_confrim);
        tvEmail = findViewById(R.id.tv_email);
        tvUsername = findViewById(R.id.tv_username);
        tvPassword = findViewById(R.id.tv_password);

    }
    private void initAction(){
        btConfrim.setOnClickListener(view -> {
            submitlogin();
        });

        etEmail.addTextChangedListener(loginTextWacher);
        etUsername.addTextChangedListener(loginTextWacher);
        etPassword.addTextChangedListener(loginTextWacher);
    }
    private void submitlogin (){
        email = etEmail.getText().toString();
        tvEmail.setText(email);

        userName = etUsername.getText().toString();
        tvUsername.setText(userName);

        password = etPassword.getText().toString();
        tvPassword.setText(password);

        SharedPreferences inputan = this.getSharedPreferences("applikasi", Context.MODE_PRIVATE);
        SharedPreferences.Editor inputEditor = inputan.edit();
        inputEditor.putString("email",email);
        inputEditor.putString("username",userName);
        inputEditor.putString("password",password);
        inputEditor.apply();

        Intent intent = new Intent(LoginActivity.this,UserListActivity.class);
        startActivity(intent);

    }

    private TextWatcher loginTextWacher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String emailInput = etEmail.getText().toString().trim();
            String usernameInput = etUsername.getText().toString().trim();
            String  passwordInput = etPassword.getText().toString().trim();

            btConfrim.setEnabled(!emailInput.isEmpty() && !usernameInput.isEmpty() && !passwordInput.isEmpty());

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}