package com.example.aparat.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.aparat.model.Videos;

import java.util.List;

@Dao
public interface DAO  {

    @Insert
    long insert(Videos videos);

    @Query("select * from tbl_videos")
    List<Videos> getVideos();

}
