package com.example.appinionsimplegalleryapp.adapter;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.appinionsimplegalleryapp.DetailsActivity;
import com.example.appinionsimplegalleryapp.R;
import com.example.appinionsimplegalleryapp.model.PhotoGalleryResponse;
import com.example.appinionsimplegalleryapp.model.Urls;

import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.MyViewHolder> {

    private List<PhotoGalleryResponse> photoLists;
    private Activity activity;

    public void setListDataItems(List<PhotoGalleryResponse> photoLists, Activity activity) {
        this.photoLists = photoLists;
        this.activity = activity;
    }

    @NonNull
    @Override
    public GalleryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryAdapter.MyViewHolder holder, int position) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.placeholder_image);
        requestOptions.error(R.drawable.error_image);
        Glide.with(holder.imageView)
                .applyDefaultRequestOptions(requestOptions)
                .load(photoLists.get(position).getUrls().getThumb())
                .into(holder.imageView);
        holder.parent.setOnClickListener(view -> {
            Intent intent = new Intent(activity, DetailsActivity.class);
            intent.putExtra("image", photoLists.get(position).getUrls().getRegular());

            activity.startActivity(intent);

        });
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
        LinearLayout parent;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            parent = itemView.findViewById(R.id.parent);
        }
    }
}
