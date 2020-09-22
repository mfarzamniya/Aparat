package com.example.aparat.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aparat.R;
import com.example.aparat.adapter.CategoryAdapter;
import com.example.aparat.databinding.FragmentCategoryBinding;
import com.example.aparat.model.Category;
import com.example.aparat.model.IMessageListener;
import com.example.aparat.webservice.WebserviceCaller;

import java.util.List;


public class CategoryFragment extends Fragment {

    FragmentCategoryBinding binding;

    WebserviceCaller webserviceCaller;

    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentCategoryBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        webserviceCaller = new WebserviceCaller();

        webserviceCaller.getCategories(new IMessageListener() {
            @Override
            public void onSuccess(Object response) {
                Log.e("", "");
                CategoryAdapter categoryAdapter = new CategoryAdapter(getActivity(), (List<Category>) response);
                binding.recyclerCategory.setAdapter(categoryAdapter);
                LinearLayoutManager manager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
                binding.recyclerCategory.setLayoutManager(manager);
            }

            @Override
            public void onFailure(Object errorResponse) {
                Log.e("", "");
            }
        });

        return view;
    }
}