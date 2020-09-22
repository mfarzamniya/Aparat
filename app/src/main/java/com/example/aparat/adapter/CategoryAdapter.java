package com.example.aparat.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aparat.R;
import com.example.aparat.activity.VideosCategoryActivity;
import com.example.aparat.model.Category;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryVH> {

    Context context;
    List<Category> categoryList;
    LayoutInflater inflater;

    public CategoryAdapter(Context context, List<Category> categoryList) {
        this.categoryList = categoryList;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public CategoryVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.category_row, null);
        CategoryVH categoryVH = new CategoryVH(view);
        return categoryVH;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryVH holder, int position) {

        Category category = categoryList.get(position);
        holder.txt_title.setText(category.getTitle());

        Picasso.get().load(category.getIcon()).into(holder.img_category);

        holder.linear_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, VideosCategoryActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.putExtra("object", category);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    class CategoryVH extends RecyclerView.ViewHolder {

        LinearLayout linear_category;
        AppCompatImageView img_category;
        AppCompatTextView txt_title;

        public CategoryVH(@NonNull View itemView) {
            super(itemView);
            img_category = itemView.findViewById(R.id.img_category);
            txt_title = itemView.findViewById(R.id.txt_title);
            linear_category = itemView.findViewById(R.id.linear_category);

        }
    }
}
