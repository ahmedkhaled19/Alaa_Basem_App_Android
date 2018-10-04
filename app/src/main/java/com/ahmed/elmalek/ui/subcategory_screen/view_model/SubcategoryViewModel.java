package com.ahmed.elmalek.ui.subcategory_screen.view_model;

import android.app.Application;
import android.support.annotation.NonNull;

import com.ahmed.elmalek.callBacks.SubcategoryCallBack;
import com.ahmed.elmalek.models.CategoryModel;
import com.ahmed.elmalek.utils.BaseViewModel;

import java.util.ArrayList;
import java.util.List;

public class SubcategoryViewModel extends BaseViewModel {

    SubcategoryCallBack callBack;

    public SubcategoryViewModel(@NonNull Application application) {
        super(application);
    }


    public void setCallBackAndGetData(SubcategoryCallBack callBack) {
        this.callBack = callBack;
        getCategoryData();
    }

    public void getCategoryData() {
        List<CategoryModel> list = new ArrayList<>();
        list.add(new CategoryModel("Restaurants",
                "https://i.ytimg.com/vi/1CeCFqeDYuM/maxresdefault.jpg"));
        list.add(new CategoryModel("Coffee Shops",
                "http://freevector.co/wp-content/uploads/2009/03/hardee-s-1.png"));
        list.add(new CategoryModel("Coffee Shops",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTO6uWQFtGqTc4FUO0ZpQmQZ4baDto4JasefJsdOKAaqa4uC1H9"));
        callBack.setSubcategoryData(list);
    }
}
