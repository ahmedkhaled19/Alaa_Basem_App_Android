package com.ahmed.elmalek.ui.category_screen.view_model;

import android.app.Application;
import android.support.annotation.NonNull;

import com.ahmed.elmalek.callBacks.CategoryCallBack;
import com.ahmed.elmalek.models.CategoryModel;
import com.ahmed.elmalek.utils.BaseViewModel;

import java.util.ArrayList;
import java.util.List;

public class CategoryFragmentViewModel extends BaseViewModel {
    CategoryCallBack callBack;

    public CategoryFragmentViewModel(@NonNull Application application) {
        super(application);
    }

    public void setCallBackAndGetData(CategoryCallBack callBack) {
        this.callBack = callBack;
        getCategoryData();
    }

    public void getCategoryData() {
        List<CategoryModel> list = new ArrayList<>();
        list.add(new CategoryModel("Restaurants",
                "http://www.edukart.com/blog/wp-content/uploads/2012/05/category-captain.jpg"));
        list.add(new CategoryModel("Coffee Shops",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRO2hYVuYiGlCP-TNXfnyG5KSwolEzhfSPI0wnjLOLlG_tJnGLV"));
        callBack.setCategoryData(list);
    }


}
