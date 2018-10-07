package com.ahmed.elmalek.ui.board_screen.view;

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
import com.ahmed.elmalek.callBacks.BoardCallBack;
import com.ahmed.elmalek.databinding.BoardLayoutBinding;
import com.ahmed.elmalek.ui.board_screen.view_model.BoardViewModel;
import com.ahmed.elmalek.ui.home_screen.view.HomeActivity;
import com.ahmed.elmalek.utils.GeneralMethods;

public class BoardFragment extends Fragment implements BoardCallBack {

    private BoardViewModel viewModel;
    private BoardLayoutBinding binding;

    public static Fragment newInstance() {
        return new BoardFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.board_layout, container, false);
        viewModel = ViewModelProviders.of(this).get(BoardViewModel.class);
        viewModel.setContextAndCallBackAndGetData(getActivity(), this);
        ((HomeActivity) getActivity()).showSlider(false);
        GeneralMethods.changeViewFont(getActivity());
        return binding.getRoot();
    }

    @Override
    public void setDataAndHideLoading() {
        binding.setBoardVM(viewModel);
        binding.boardProgressBar.setVisibility(View.GONE);
    }
}
