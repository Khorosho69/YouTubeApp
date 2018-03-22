package com.antont.youtubeapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.antont.youtubeapp.R;
import com.antont.youtubeapp.models.VideoItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RowViewHolder> {
    private List<VideoItem> mVideoItems;

    private OnItemSelectedCallback mListener;

    public RecyclerViewAdapter(List<VideoItem> videoItems, OnItemSelectedCallback listener) {
        mVideoItems = videoItems;
        mListener = listener;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.RowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_item_layout, parent, false);
        return new RowViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.RowViewHolder holder, int position) {
        VideoItem item = mVideoItems.get(position);

        Picasso.get().load(item.getPreviewImageUrl())
                .placeholder(R.color.colorPrimary)
                .fit()
                .centerCrop()
                .into(holder.mImageView);
        holder.mTextView.setText(item.getVideoName());

        holder.itemView.setOnClickListener((View view) -> mListener.onItemSelected(item.getVideoId()));
    }

    @Override
    public int getItemCount() {
        return mVideoItems.size();
    }

    class RowViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        TextView mTextView;

        RowViewHolder(View v) {
            super(v);
            mTextView = v.findViewById(R.id.video_name_text);
            mImageView = v.findViewById(R.id.video_preview_image);
        }
    }

    public interface OnItemSelectedCallback {
        void onItemSelected(String videoId);
    }
}