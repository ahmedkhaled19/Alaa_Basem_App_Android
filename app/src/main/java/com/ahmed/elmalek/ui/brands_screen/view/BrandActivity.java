package com.ahmed.elmalek.ui.brands_screen.view;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.ahmed.elmalek.R;
import com.ahmed.elmalek.callBacks.BrandProfileCallBack;
import com.ahmed.elmalek.databinding.BrandActivityBinding;
import com.ahmed.elmalek.ui.brands_screen.view_model.BrandViewModel;

public class BrandActivity extends AppCompatActivity implements BrandProfileCallBack {

    private BrandViewModel viewModel;
    private BrandActivityBinding binding;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_speech:
                    if (!item.isChecked()) {
                        changeFragment(1);
                    }
                    return true;
                case R.id.navigation_checkList:
                    if (!item.isChecked()) {
                        changeFragment(2);
                    }
                    return true;
                case R.id.navigation_attach:
                    if (!item.isChecked()) {
                        changeFragment(3);
                    }
                    return true;
                case R.id.navigation_conversation:
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
        binding = DataBindingUtil.setContentView(this, R.layout.brand_activity);
        viewModel = ViewModelProviders.of(this).get(BrandViewModel.class);
        viewModel.setContextAndCallBackAndGetData("", this, this);
        binding.brandNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        fragmentManager = getSupportFragmentManager();
        fragmentManager.findFragmentById(R.id.brand_frame);
    }

    @Override
    public void setViewModel() {
        binding.setBrandVM(viewModel);
    }

    private void changeFragment(int index) {
        fragmentTransaction = fragmentManager.beginTransaction();
        if (index == 1) {
        } else if (index == 2) {
        } else if (index == 3) {
        } else if (index == 4) {
        }
    }


}
