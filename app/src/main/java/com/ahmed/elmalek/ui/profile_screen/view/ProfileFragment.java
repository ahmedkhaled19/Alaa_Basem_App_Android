package com.ahmed.elmalek.ui.profile_screen.view;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ahmed.elmalek.R;
import com.ahmed.elmalek.databinding.ProfileLayoutBinding;
import com.ahmed.elmalek.ui.home_screen.view.HomeActivity;
import com.ahmed.elmalek.ui.profile_screen.view_model.ProfileViewModel;

public class ProfileFragment extends Fragment {

    ProfileViewModel viewModel;
    ProfileLayoutBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.profile_layout, container, false);
        viewModel = ViewModelProviders.of(this).get(ProfileViewModel.class);
        binding.setProfileVM(viewModel);
        ((HomeActivity) getActivity()).showSlider(false);
        return binding.getRoot();
    }
}
