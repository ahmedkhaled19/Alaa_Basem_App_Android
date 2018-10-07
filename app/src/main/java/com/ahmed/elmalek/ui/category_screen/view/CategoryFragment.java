package com.ahmed.elmalek.ui.category_screen.view;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ahmed.elmalek.R;
import com.ahmed.elmalek.adapters.CategoryAdapter;
import com.ahmed.elmalek.callBacks.CategoryCallBack;
import com.ahmed.elmalek.databinding.CategoryLayoutBinding;
import com.ahmed.elmalek.models.CategoryModel;
import com.ahmed.elmalek.ui.category_screen.view_model.CategoryFragmentViewModel;
import com.ahmed.elmalek.ui.home_screen.view.HomeActivity;
import com.ahmed.elmalek.ui.subcategory_screen.view.SubcategoryFragment;
import com.ahmed.elmalek.utils.GeneralMethods;

import java.util.List;

public class CategoryFragment extends Fragment implements CategoryCallBack {

    private CategoryLayoutBinding binding;
    private CategoryAdapter adapter;
    private CategoryFragmentViewModel viewModel;


    public static Fragment newInstance() {
        return new CategoryFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.category_layout, container, false);
        viewModel = ViewModelProviders.of(this).get(CategoryFragmentViewModel.class);
        binding.setCategoryVM(viewModel);
        viewModel.setCallBackAndGetData(this);
        ((HomeActivity) getActivity()).showSlider(true);
        GeneralMethods.changeViewFont(getActivity());
        return binding.getRoot();
    }

    @Override
    public void setCategoryData(List<CategoryModel> categoryModelList) {
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        adapter = new CategoryAdapter(categoryModelList, getActivity(), this);
        binding.categoryFragmentRecyclerView.setLayoutManager(layoutManager);
        binding.categoryFragmentRecyclerView.setAdapter(adapter);
    }

    @Override
    public void moveToSubCategory(String categoryId) {
        ((HomeActivity) getActivity()).setSubcategoryOpened(true);
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        fragmentManager = getFragmentManager();
        fragmentManager.findFragmentById(R.id.home_frame_layout);
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.home_frame_layout, SubcategoryFragment.newInstance())
                .addToBackStack("subcategory")
                .commit();
    }
}
