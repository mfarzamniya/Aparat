package com.example.aparat.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import com.example.aparat.R;
import com.example.aparat.adapter.VideoGridAdapter;
import com.example.aparat.databinding.ActivityVideosCategoryBinding;
import com.example.aparat.model.Category;
import com.example.aparat.model.IMessageListener;
import com.example.aparat.model.Videos;
import com.example.aparat.webservice.WebserviceCaller;

import java.util.List;

public class VideosCategoryActivity extends AppCompatActivity {

    Bundle bundle;
    Category category;
    WebserviceCaller webserviceCaller;

    ActivityVideosCategoryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVideosCategoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        bundle = getIntent().getExtras();
        category = bundle.getParcelable("object");
        Log.e("", "");

        webserviceCaller = new WebserviceCaller();
        webserviceCaller.getVideosCategory(Integer.parseInt(category.getId()), new IMessageListener() {
            @Override
            public void onSuccess(Object response) {
                Log.e("", "");

                VideoGridAdapter videoGridAdapter = new VideoGridAdapter(getApplicationContext(), (List<Videos>) response);
                binding.recyclerVideos.setAdapter(videoGridAdapter);
                GridLayoutManager manager = new GridLayoutManager(getApplicationContext(), 2);
                binding.recyclerVideos.setLayoutManager(manager);
            }

            @Override
            public void onFailure(Object errorResponse) {
                Log.e("", "");
            }
        });
    }
}