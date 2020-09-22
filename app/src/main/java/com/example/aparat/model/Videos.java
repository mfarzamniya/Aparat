package com.example.aparat.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "tbl_videos")
public class Videos implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "videoId")
    private
    int videoId;

    @SerializedName("id")
    @Expose
    @ColumnInfo(name = "id")
    private String id;
    @SerializedName("cat_id")
    @Expose
    @ColumnInfo(name = "catId")
    private String catId;
    @SerializedName("title")
    @Expose
    @ColumnInfo(name = "title")
    private String title;
    @SerializedName("icon")
    @Expose
    @ColumnInfo(name = "icon")
    private String icon;
    @SerializedName("creator")
    @Expose
    @ColumnInfo(name = "creator")
    private String creator;
    @SerializedName("description")
    @Expose
    @ColumnInfo(name = "description")
    private String description;
    @SerializedName("link")
    @Expose
    @ColumnInfo(name = "link")
    private String link;
    @SerializedName("view")
    @Expose
    @ColumnInfo(name = "view")
    private String view;
    @SerializedName("time")
    @Expose
    @ColumnInfo(name = "time")
    private String time;
    @SerializedName("special")
    @Expose
    @ColumnInfo(name = "special")
    private String special;

    public Videos (String id, String catId, String title, String icon, String creator, String description, String link,
                   String view, String time, String special) {

        this.setId(id);
        this.setCatId(catId);
        this.setTitle(title);
        this.setIcon(icon);
        this.setCreator(creator);
        this.setDescription(description);
        this.setLink(link);
        this.setView(view);
        this.setTime(time);
        this.setSpecial(special);

    }

    @Ignore
    public Videos (int videoId, String id, String catId, String title, String icon, String creator, String description, String link,
                   String view, String time, String special) {

        this.setVideoId(videoId);
        this.setId(id);
        this.setCatId(catId);
        this.setTitle(title);
        this.setIcon(icon);
        this.setCreator(creator);
        this.setDescription(description);
        this.setLink(link);
        this.setView(view);
        this.setTime(time);
        this.setSpecial(special);

    }



    @Ignore
    protected Videos(Parcel in) {
        id = in.readString();
        catId = in.readString();
        title = in.readString();
        icon = in.readString();
        creator = in.readString();
        description = in.readString();
        link = in.readString();
        view = in.readString();
        time = in.readString();
        special = in.readString();
    }

    public static final Creator<Videos> CREATOR = new Creator<Videos>() {
        @Override
        public Videos createFromParcel(Parcel in) {
            return new Videos(in);
        }

        @Override
        public Videos[] newArray(int size) {
            return new Videos[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(catId);
        dest.writeString(title);
        dest.writeString(icon);
        dest.writeString(creator);
        dest.writeString(description);
        dest.writeString(link);
        dest.writeString(view);
        dest.writeString(time);
        dest.writeString(special);
    }


    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }
}

