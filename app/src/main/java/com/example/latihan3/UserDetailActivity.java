package com.example.latihan3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.latihan3.databinding.ActivityUserDetailBinding;

public class UserDetailActivity extends AppCompatActivity {
    private UserModel userModel;
    private ActivityUserDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_user_detail);

        userModel = getIntent().getExtras().getParcelable("userModel");
        binding.setUserModel(userModel);
    }
}