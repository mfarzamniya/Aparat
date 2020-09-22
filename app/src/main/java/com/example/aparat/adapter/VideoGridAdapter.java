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
import com.example.aparat.activity.VideoPlayerActivity;
import com.example.aparat.model.Videos;
import com.squareup.picasso.Picasso;

import java.util.List;

public class VideoGridAdapter extends RecyclerView.Adapter<VideoGridAdapter.VideoVH> {

    Context context;
    List<Videos> videosList;
    LayoutInflater inflater;

    public VideoGridAdapter (Context context, List<Videos> videosList) {
        this.context = context;
        this.videosList = videosList;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public VideoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.videos_grid_row, null);
        VideoVH videoVH = new VideoVH(view);
        return videoVH;
    }

    @Override
    public void onBindViewHolder(@NonNull VideoVH holder, int position) {

        Videos videos = videosList.get(position);

        holder.txt_title.setText(videos.getTitle());

        Picasso.get().load(videos.getIcon()).into(holder.img_category);

        holder.linear_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, VideoPlayerActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("object", videos);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return videosList.size();
    }


    class VideoVH extends RecyclerView.ViewHolder {

        AppCompatImageView img_category;
        AppCompatTextView txt_title;
        LinearLayout linear_category;

        public VideoVH(@NonNull View itemView) {
            super(itemView);

            img_category = itemView.findViewById(R.id.img_category);
            txt_title = itemView.findViewById(R.id.txt_title);
            linear_category = itemView.findViewById(R.id.linear_category);
        }
    }
}
