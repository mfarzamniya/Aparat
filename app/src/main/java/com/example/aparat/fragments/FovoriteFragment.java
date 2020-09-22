package com.example.aparat.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aparat.R;
import com.example.aparat.adapter.VideoGridAdapter;
import com.example.aparat.database.AppDatabase;
import com.example.aparat.databinding.FragmentFovoriteBinding;
import com.example.aparat.model.Videos;

import java.util.List;


public class FovoriteFragment extends Fragment {

    FragmentFovoriteBinding binding;

    AppDatabase appDatabase;

    public FovoriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentFovoriteBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        appDatabase = AppDatabase.getInstance(getActivity());
        List<Videos> videosList = appDatabase.getDAO().getVideos();
        Log.e("", "");

        binding.recyclerVideos.setAdapter(new VideoGridAdapter(getActivity(), (List<Videos>) videosList));
        binding.recyclerVideos.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        return view;
    }
}