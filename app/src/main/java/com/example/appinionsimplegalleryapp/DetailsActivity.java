package com.example.appinionsimplegalleryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.appinionsimplegalleryapp.databinding.ActivityDetailsBinding;
import com.example.appinionsimplegalleryapp.databinding.ActivityMainBinding;

public class DetailsActivity extends AppCompatActivity {
    ActivityDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_details);

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.placeholder_image);
        requestOptions.error(R.drawable.error_image);
        Glide.with(binding.imageView)
                .applyDefaultRequestOptions(requestOptions)
                .load(getIntent().getStringExtra("image"))
                .into(binding.imageView);
    }
}