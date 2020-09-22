package com.example.aparat.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.aparat.R;
import com.example.aparat.database.AppDatabase;
import com.example.aparat.databinding.ActivityVideoPlayerBinding;
import com.example.aparat.model.Videos;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

import java.util.List;

public class VideoPlayerActivity extends AppCompatActivity {

    Bundle bundle;
    Videos videos;

    ActivityVideoPlayerBinding binding;

    SimpleExoPlayer player;

    AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVideoPlayerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        appDatabase = AppDatabase.getInstance(getApplicationContext());

        bundle = getIntent().getExtras();
        videos = bundle.getParcelable("object");

        binding.txtPageTitle.setText(videos.getTitle());
        binding.txtDescription.setText(videos.getTitle());


        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        player = ExoPlayerFactory.newSimpleInstance(getApplicationContext(), new DefaultTrackSelector());

        Uri uri = Uri.parse(videos.getLink());

        DataSource.Factory dataSource = new DefaultDataSourceFactory(getApplicationContext(), Util.getUserAgent(
                getApplicationContext(), "Aparat"
        ));

        MediaSource mediaSource = new ExtractorMediaSource.Factory(dataSource).createMediaSource(uri);

        player.prepare(mediaSource);

        binding.videoView.setPlayer(player);
        player.setPlayWhenReady(true);

        binding.imgFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Videos videosObject = new Videos(videos.getId(), videos.getCatId(), videos.getTitle(), videos.getIcon(), videos.getCreator(),
                        videos.getDescription(), videos.getLink(), videos.getView(), videos.getTime(), videos.getSpecial());

                long result = appDatabase.getDAO().insert(videosObject);

                if(result > 0) {
                    Toast.makeText(getApplicationContext(), "Added", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(player != null) {
            player.stop();
        }
    }
}