package com.example.aparat.webservice;

import android.util.Log;

import com.example.aparat.model.Category;
import com.example.aparat.model.IMessageListener;
import com.example.aparat.model.News;
import com.example.aparat.model.Videos;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WebserviceCaller {

    IService iService;

    public WebserviceCaller() {
        iService = ApiClient.getRetrofit().create(IService.class);
    }

    public void getNewVideos(IMessageListener listener) {

        Call<List<Videos>> call = iService.getNewVideos();
        call.enqueue(new Callback<List<Videos>>() {
            @Override
            public void onResponse(Call<List<Videos>> call, Response<List<Videos>> response) {
                Log.e("", "");
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Videos>> call, Throwable t) {
                Log.e("", "");
                listener.onFailure(t.getMessage().toString() + "");
            }
        });
    }

    public void getSpecial(IMessageListener listener) {

        Call<List<Videos>> call = iService.getSpecial();
        call.enqueue(new Callback<List<Videos>>() {
            @Override
            public void onResponse(Call<List<Videos>> call, Response<List<Videos>> response) {
                Log.e("", "");
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Videos>> call, Throwable t) {
                Log.e("","");
                listener.onFailure(t.getMessage().toString() + "");
            }
        });
    }

    public void getCategories(IMessageListener listener) {

        Call<List<Category>> call = iService.getCategories();
        call.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                Log.e("","");
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                listener.onFailure(t.getMessage().toString() + "");
            }
        });

    }

    public void getVideosCategory (int id, IMessageListener listener) {

        Call<List<Videos>> call = iService.getVideosCategory(id);
        call.enqueue(new Callback<List<Videos>>() {
            @Override
            public void onResponse(Call<List<Videos>> call, Response<List<Videos>> response) {
                Log.e("", "");
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Videos>> call, Throwable t) {
                Log.e("", "");
                listener.onFailure(t.getMessage().toString() + "");
            }
        });
    }


    public void getNews(IMessageListener listener) {

        Call<List<News>> call = iService.getNews();
        call.enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                Log.e("", "");
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                Log.e("", "");
                listener.onFailure(t.getMessage().toString() + "");
            }
        });


    }



}
