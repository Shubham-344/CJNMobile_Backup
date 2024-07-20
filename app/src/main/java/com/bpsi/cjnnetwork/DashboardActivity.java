package com.bpsi.cjnnetwork;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.bpsi.cjnnetwork.BottomNavigation.AssesmentNavigationFragment;
import com.bpsi.cjnnetwork.BottomNavigation.DashboardNavigationFragment;
import com.bpsi.cjnnetwork.BottomNavigation.InterviewNavigationFragment;
import com.bpsi.cjnnetwork.BottomNavigation.JobOfferNavigationFragment;
import com.bpsi.cjnnetwork.BottomNavigation.ProfileNavigationFragment;
import com.bpsi.cjnnetwork.BottomNavigation.TrainingNavigationFragment;
import com.bpsi.cjnnetwork.databinding.ActivityDashboardBinding;

import nl.joery.animatedbottombar.AnimatedBottomBar;

public class DashboardActivity extends AppCompatActivity {
    private ActivityDashboardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new DashboardNavigationFragment());
        binding.btmNavigation.setOnTabSelectListener(new AnimatedBottomBar.OnTabSelectListener() {
            @Override
            public void onTabSelected(int lastIndex, AnimatedBottomBar.Tab lastTab, int newIndex, AnimatedBottomBar.Tab newTab) {
                switch (newIndex) {
                    case 0:
                        replaceFragment(new DashboardNavigationFragment());
                        break;
                    case 1:
                        replaceFragment(new TrainingNavigationFragment());
                        break;
                    case 2:
                        replaceFragment(new AssesmentNavigationFragment());
                        break;
                    case 3:
                        replaceFragment(new InterviewNavigationFragment());
                        break;
                    case 4:
                        replaceFragment(new JobOfferNavigationFragment());
                        break;
                    case 5:
                        replaceFragment(new ProfileNavigationFragment());
                        break;
                    default:

                        break;
                }
            }

            @Override
            public void onTabReselected(int i, AnimatedBottomBar.Tab tab) {
            }
        });


    }

    public void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment).commit();
    }

    @Override
    public void onBackPressed() {
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.fragment);
        if (!(currentFragment instanceof DashboardNavigationFragment)) {
            replaceFragment(new DashboardNavigationFragment());
            binding.btmNavigation.selectTabAt(0,true);
        } else {
            super.onBackPressed();
        }
    }

    public void setIndex(int index){
        replaceFragment(new TrainingNavigationFragment());
        binding.btmNavigation.selectTabAt(index,true);
    }


}