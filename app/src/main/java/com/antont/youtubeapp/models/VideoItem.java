package com.antont.youtubeapp.models;

public class VideoItem {
    private String mVideoId;
    private String mVideoName;
    private String mPreviewImageUrl;

    public VideoItem(String videoId, String videoName, String previewImageUrl) {
        mVideoId = videoId;
        mVideoName = videoName;
        mPreviewImageUrl = previewImageUrl;
    }

    public String getPreviewImageUrl() {
        return mPreviewImageUrl;
    }

    public String getVideoId() {
        return mVideoId;
    }

    public String getVideoName() {
        return mVideoName;
    }
}
