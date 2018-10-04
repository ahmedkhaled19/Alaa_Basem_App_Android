package com.ahmed.elmalek.ui.home_screen.view;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
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
import com.ahmed.elmalek.ui.home_screen.view_model.HomeViewModel;
import com.ahmed.elmalek.ui.profile_screen.view.ProfileFragment;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding homeBinding;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private HomeViewModel viewModel;
    private boolean isSubcategoryOpened = false;

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
        homeBinding.homeNavigation.getMenu().getItem(0).setChecked(true);
        viewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        viewModel.setContextAndGetSliderImageData(this, homeBinding.homeSliderImage);
        fragmentManager = getSupportFragmentManager();
        fragmentManager.findFragmentById(R.id.home_frame_layout);
        changeFragment(1);
    }


    private void changeFragment(int index) {
        fragmentTransaction = fragmentManager.beginTransaction();
        if (index == 1) {
            showSlider(true);
            CategoryFragment categoryFragment = new CategoryFragment();
            fragmentTransaction.replace(R.id.home_frame_layout, categoryFragment)
                    .addToBackStack("home")
                    .commit();
        } else if (index == 2) {
            ProfileFragment profileFragment = new ProfileFragment();
            fragmentTransaction.replace(R.id.home_frame_layout, profileFragment)
                    .addToBackStack("profile")
                    .commit();
        } else if (index == 3) {

        } else if (index == 4) {
        }
    }

    public void showSlider(boolean show) {
        if (show) {
            homeBinding.homeSliderImage.setVisibility(View.VISIBLE);
        } else {
            homeBinding.homeSliderImage.setVisibility(View.GONE);
        }

    }

    public void setSubcategoryOpened(boolean subcategoryOpened) {
        isSubcategoryOpened = subcategoryOpened;
    }

    @Override
    public void onBackPressed() {
        if (isSubcategoryOpened) {
            changeFragment(1);
            isSubcategoryOpened = false;
        } else {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finishAffinity();
            System.exit(0);
            super.onBackPressed();
        }
    }

}
