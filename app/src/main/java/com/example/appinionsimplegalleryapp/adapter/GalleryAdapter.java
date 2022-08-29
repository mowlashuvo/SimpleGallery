package com.example.appinionsimplegalleryapp.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.appinionsimplegalleryapp.R;
import com.example.appinionsimplegalleryapp.model.PhotoGalleryResponse;
import com.example.appinionsimplegalleryapp.model.Urls;

import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.MyViewHolder> {

    private List<PhotoGalleryResponse> photoLists;

    public void setListDataItems(List<PhotoGalleryResponse> photoLists) {
        this.photoLists = photoLists;
        Log.d("TAG", "GalleryAdapter: "+this.photoLists.size());
    }

    @NonNull
    @Override
    public GalleryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryAdapter.MyViewHolder holder, int position) {
        Glide.with(holder.imageView)
                .load(photoLists.get(position).getUrls().getThumb())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        if (photoLists == null)
            return 0;
        else
            return photoLists.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
