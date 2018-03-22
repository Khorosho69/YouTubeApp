package com.antont.youtubeapp.architecture_components;

import android.arch.lifecycle.ViewModel;

import com.antont.youtubeapp.models.VideoItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends ViewModel {
    private List<VideoItem> mVideoItems = new ArrayList<>();

    public List<VideoItem> getVideoItems() {
        return mVideoItems;
    }

    public void setVideoItems(List<VideoItem> videoItems) {
        if (!mVideoItems.isEmpty()) {
            mVideoItems.clear();
        }
        mVideoItems.addAll(videoItems);
    }
}
