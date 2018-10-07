package com.ahmed.elmalek.ui.subcategory_screen.view;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ahmed.elmalek.R;
import com.ahmed.elmalek.adapters.SubcategoryAdapter;
import com.ahmed.elmalek.callBacks.SubcategoryCallBack;
import com.ahmed.elmalek.databinding.SubcategoryLayoutBinding;
import com.ahmed.elmalek.models.CategoryModel;
import com.ahmed.elmalek.ui.subcategory_screen.view_model.SubcategoryViewModel;
import com.ahmed.elmalek.utils.GeneralMethods;

import java.util.List;

public class SubcategoryFragment extends Fragment implements SubcategoryCallBack {

    private SubcategoryLayoutBinding binding;
    private SubcategoryViewModel viewModel;
    private SubcategoryAdapter adapter;

    public static Fragment newInstance() {
        return new SubcategoryFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.subcategory_layout, container, false);
        viewModel = ViewModelProviders.of(this).get(SubcategoryViewModel.class);
        viewModel.setCallBackAndGetData(this);
        binding.setSubcategoryVM(viewModel);
        GeneralMethods.changeViewFont(getActivity());
        return binding.getRoot();
    }

    @Override
    public void setSubcategoryData(List<CategoryModel> subcategoryData) {
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        adapter = new SubcategoryAdapter(subcategoryData, getActivity());
        binding.subcategoryRecyclerView.setLayoutManager(layoutManager);
        binding.subcategoryRecyclerView.setAdapter(adapter);
    }
}
