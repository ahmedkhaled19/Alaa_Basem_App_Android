package com.ahmed.elmalek.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ahmed.elmalek.R;
import com.ahmed.elmalek.callBacks.CategoryCallBack;
import com.ahmed.elmalek.databinding.CategoryListItemBinding;
import com.ahmed.elmalek.models.CategoryModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<CategoryModel> list;
    private Context context;
    private CategoryCallBack callBack;

    public CategoryAdapter(List<CategoryModel> list, Context context, CategoryCallBack callBack) {
        this.list = list;
        this.context = context;
        this.callBack = callBack;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_list_item, viewGroup, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        Picasso.with(context)
                .load(list.get(position).getImageURL())
                .into(((CategoryViewHolder) viewHolder).binding.categoryItemImage);
        ((CategoryViewHolder) viewHolder).binding.categoryItemName.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class CategoryViewHolder extends RecyclerView.ViewHolder {
        CategoryListItemBinding binding;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

    }
}
