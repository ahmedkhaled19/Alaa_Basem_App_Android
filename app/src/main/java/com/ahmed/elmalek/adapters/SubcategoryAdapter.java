package com.ahmed.elmalek.adapters;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ahmed.elmalek.R;
import com.ahmed.elmalek.databinding.SubcategoryListItemBinding;
import com.ahmed.elmalek.models.CategoryModel;
import com.ahmed.elmalek.ui.brands_screen.view.BrandActivity;
import com.ahmed.elmalek.utils.GeneralMethods;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SubcategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<CategoryModel> list;
    private Context context;

    public SubcategoryAdapter(List<CategoryModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.subcategory_list_item, viewGroup, false);
        GeneralMethods.changeItemFont(view);
        return new SubCategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        Picasso.with(context)
                .load(list.get(position).getImageURL())
                .into(((SubCategoryViewHolder) viewHolder).binding.subcategoryItemImage);

        ((SubCategoryViewHolder) viewHolder).binding.subcategoryItemImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, BrandActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class SubCategoryViewHolder extends RecyclerView.ViewHolder {
        SubcategoryListItemBinding binding;

        public SubCategoryViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

    }
}
