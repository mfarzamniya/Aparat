package com.example.aparat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewpager.widget.PagerAdapter;

import com.example.aparat.R;
import com.example.aparat.model.News;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter extends PagerAdapter {

    Context context;
    List<News> newsList;
    LayoutInflater inflater;

    public NewsAdapter (Context context, List<News> newsList) {
        this.context = context;
        this.newsList = newsList;
        inflater = LayoutInflater.from(context);
    }



    @Override
    public int getCount() {
        return newsList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        News news = newsList.get(position);

        View view = inflater.inflate(R.layout.slider_view, null);
        AppCompatImageView imageView = view.findViewById(R.id.image);

        Picasso.get().load(news.getIcon()).into(imageView);

        container.addView(view, 0);
        return view;
    }
}
