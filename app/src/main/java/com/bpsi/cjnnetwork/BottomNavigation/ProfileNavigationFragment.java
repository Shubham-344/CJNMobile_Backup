package com.bpsi.cjnnetwork.BottomNavigation;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bpsi.cjnnetwork.databinding.FragmentProfileNavigationBinding;
import com.bpsi.cjnnetwork.model.LoginDataOutput;
import com.bpsi.cjnnetwork.profile.EditProfileActivity;
import com.bpsi.cjnnetwork.utils.SingletonUserData;

public class ProfileNavigationFragment extends Fragment {
    private static final int REQUEST_VIDEO_PICK = 1;
    private FragmentProfileNavigationBinding binding;
    LoginDataOutput loginDataOutput = SingletonUserData.getInstance().getLoginDataOutput();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentProfileNavigationBinding.inflate(inflater, container, false);

        binding.ivEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(requireContext(), EditProfileActivity.class));
            }
        });
        binding.addVidumeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickVideo();
            }
        });
        setdata();

//        binding.btnProfile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(requireContext(), "Profile", Toast.LENGTH_SHORT).show();
//            }
//        });
//        binding.btnCreateProfile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(requireActivity(), AddProfileInfo.class));
//            }
//        });

        return binding.getRoot();
    }
    private void pickVideo() {

        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("video/*");
        startActivityForResult(intent, REQUEST_VIDEO_PICK);

    }
    private void setdata() {
        binding.tvName.setText(loginDataOutput.getFullname());
        binding.tvNameProfile.setText(loginDataOutput.getFullname());
        binding.tvEmailProfile.setText(loginDataOutput.getEmail());
        binding.tvContactProfile.setText(loginDataOutput.getMobile());
    }
}