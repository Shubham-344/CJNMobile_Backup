package com.bpsi.cjnnetwork.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bpsi.cjnnetwork.databinding.ActivityEditProfileBinding;

public class EditProfileActivity extends AppCompatActivity {
    private ActivityEditProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityEditProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
}