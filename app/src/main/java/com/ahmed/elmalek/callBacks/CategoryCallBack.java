package com.ahmed.elmalek.callBacks;

import com.ahmed.elmalek.models.CategoryModel;

import java.util.List;

public interface CategoryCallBack {

    void setCategoryData(List<CategoryModel> categoryModelList);

    void moveToSubCategory(String categoryId);

}
