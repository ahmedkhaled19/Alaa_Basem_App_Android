package com.ahmed.elmalek.ui.home_screen;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.ahmed.elmalek.R;
import com.ahmed.elmalek.databinding.ActivityHomeBinding;
import com.ahmed.elmalek.ui.category_screen.view.CategoryFragment;
import com.ahmed.elmalek.ui.profile_screen.view.ProfileFrgment;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding homeBinding;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    if (!item.isChecked()) {
                        changeFragment(1);
                    }
                    return true;
                case R.id.navigation_coin:
                    if (!item.isChecked()) {
                        changeFragment(2);
                    }
                    return true;
                case R.id.navigation_coins:
                    if (!item.isChecked()) {
                        changeFragment(3);
                    }
                    return true;
                case R.id.navigation_paper_plane:
                    if (!item.isChecked()) {
                        changeFragment(4);
                    }
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        homeBinding.homeNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        fragmentManager = getSupportFragmentManager();
        fragmentManager.findFragmentById(R.id.home_frame_layout);
        homeBinding.homeNavigation.getMenu().getItem(0).setChecked(true);
        changeFragment(1);
    }


    private void changeFragment(int index) {
        fragmentTransaction = fragmentManager.beginTransaction();
        if (index == 1) {
            homeBinding.homeSliderImage.setVisibility(View.VISIBLE);
            CategoryFragment categoryFragment = new CategoryFragment();
            fragmentTransaction.replace(R.id.home_frame_layout, categoryFragment)
                    .addToBackStack("home")
                    .commit();
        } else if (index == 2) {
            homeBinding.homeSliderImage.setVisibility(View.GONE);
            ProfileFrgment profileFrgment = new ProfileFrgment();
            fragmentTransaction.replace(R.id.home_frame_layout, profileFrgment)
                    .addToBackStack("home")
                    .commit();

        } else if (index == 3) {
            homeBinding.homeSliderImage.setVisibility(View.GONE);
        } else if (index == 4) {
            homeBinding.homeSliderImage.setVisibility(View.GONE);
        }
    }

}
