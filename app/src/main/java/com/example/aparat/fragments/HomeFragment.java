package com.example.aparat.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aparat.R;
import com.example.aparat.adapter.NewsAdapter;
import com.example.aparat.adapter.TabsAdapter;
import com.example.aparat.adapter.VideosAdapter;
import com.example.aparat.model.IMessageListener;
import com.example.aparat.model.News;
import com.example.aparat.model.Videos;
import com.example.aparat.webservice.WebserviceCaller;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import java.util.List;


public class HomeFragment extends Fragment {

    WebserviceCaller webserviceCaller;
    RecyclerView recycler_new_videos;
    RecyclerView recycler_special_videos;
    ViewPager pager;
    DotsIndicator dots_indicator;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recycler_new_videos = view.findViewById(R.id.recycler_new_videos);
        recycler_special_videos = view.findViewById(R.id.recycler_special_videos);
        pager = view.findViewById(R.id.pager);
        dots_indicator = view.findViewById(R.id.dots_indicator);

        webserviceCaller = new WebserviceCaller();
        webserviceCaller.getNewVideos(new IMessageListener() {
            @Override
            public void onSuccess(Object response) {
                Log.e("", "");
               VideosAdapter videosAdapter = new VideosAdapter(getActivity(), (List<Videos>) response);
                recycler_new_videos.setAdapter(videosAdapter);
                LinearLayoutManager manager = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);
                recycler_new_videos.setLayoutManager(manager);
            }

            @Override
            public void onFailure(Object errorResponse) {
                Log.e("", "");
            }
        });


        webserviceCaller.getSpecial(new IMessageListener() {
            @Override
            public void onSuccess(Object response) {

                VideosAdapter videosAdapter = new VideosAdapter(getActivity(), (List<Videos>) response);
                recycler_special_videos.setAdapter(videosAdapter);
                LinearLayoutManager manager = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);
                recycler_special_videos.setLayoutManager(manager);

            }

            @Override
            public void onFailure(Object errorResponse) {

            }
        });

        webserviceCaller.getNews(new IMessageListener() {
            @Override
            public void onSuccess(Object response) {

                NewsAdapter newsAdapter = new NewsAdapter(getActivity(), (List<News>) response);
                pager.setAdapter(newsAdapter);
                dots_indicator.setViewPager(pager);
            }

            @Override
            public void onFailure(Object errorResponse) {

            }
        });




        return view;
    }
}