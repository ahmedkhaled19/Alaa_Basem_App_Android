package com.ahmed.elmalek.ui.category_screen.view;

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
import com.ahmed.elmalek.adapters.CategoryAdapter;
import com.ahmed.elmalek.callBacks.CategoryCallBack;
import com.ahmed.elmalek.databinding.CategoryLayoutBinding;
import com.ahmed.elmalek.models.CategoryModel;
import com.ahmed.elmalek.ui.category_screen.view_model.CategoryFragmentViewModel;

import java.util.List;

public class CategoryFragment extends Fragment implements CategoryCallBack {

    private CategoryLayoutBinding binding;
    private CategoryAdapter adapter;
    private CategoryFragmentViewModel viewModel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.category_layout, container, false);
        viewModel = ViewModelProviders.of(this).get(CategoryFragmentViewModel.class);
        binding.setCategoryVM(viewModel);
        return binding.getRoot();
    }

    @Override
    public void setCategoryData(List<CategoryModel> categoryModelList) {

    }

    @Override
    public void moveToSubCategory(String categoryId) {

    }
}
