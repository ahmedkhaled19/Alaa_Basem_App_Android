package com.ahmed.elmalek.ui.profile_screen.view;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ahmed.elmalek.R;
import com.ahmed.elmalek.adapters.NotificationAdapter;
import com.ahmed.elmalek.callBacks.ProfileCallBack;
import com.ahmed.elmalek.databinding.ProfileLayoutBinding;
import com.ahmed.elmalek.models.NotificationModel;
import com.ahmed.elmalek.ui.home_screen.view.HomeActivity;
import com.ahmed.elmalek.ui.profile_screen.view_model.ProfileViewModel;
import com.ahmed.elmalek.utils.GeneralMethods;

import java.util.List;

public class ProfileFragment extends Fragment implements ProfileCallBack {

    ProfileViewModel viewModel;
    ProfileLayoutBinding binding;
    NotificationAdapter adapter;

    public static Fragment newInstance() {
        return new ProfileFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.profile_layout, container, false);
        viewModel = ViewModelProviders.of(this).get(ProfileViewModel.class);
        viewModel.setContextAndsetCallBackAndGetData(getActivity(), this);
        binding.setProfileVM(viewModel);
        ((HomeActivity) getActivity()).showSlider(false);
        GeneralMethods.changeViewFont(getActivity());
        return binding.getRoot();
    }

    @Override
    public void setNotificationData(List<NotificationModel> notificationModelList) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        adapter = new NotificationAdapter(notificationModelList, getActivity());
        binding.profileRecycler.setLayoutManager(layoutManager);
        binding.profileRecycler.setAdapter(adapter);
    }
}
