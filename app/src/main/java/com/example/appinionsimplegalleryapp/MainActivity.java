package com.example.appinionsimplegalleryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.appinionsimplegalleryapp.adapter.GalleryAdapter;
import com.example.appinionsimplegalleryapp.databinding.ActivityMainBinding;
import com.example.appinionsimplegalleryapp.model.PhotoGalleryResponse;
import com.example.appinionsimplegalleryapp.viewmodel.MainActivityViewModel;

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    private GalleryAdapter adapter;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main);
        initRecyclerView();
        initViewModel();
    }

    private void initRecyclerView(){
        binding.recyclerView.setVisibility(View.GONE);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new GalleryAdapter();
        binding.recyclerView.setAdapter(adapter);
    }

    private void initViewModel(){
        MainActivityViewModel viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        viewModel.getLiveData().observe(this, new Observer<List<PhotoGalleryResponse>>() {
            @Override
            public void onChanged(List<PhotoGalleryResponse> photoGalleryResponse) {
                if (photoGalleryResponse != null){
                    adapter.setListDataItems(photoGalleryResponse, MainActivity.this);
                    adapter.notifyDataSetChanged();
                    binding.simpleProgressBar.setVisibility(View.GONE);
                    binding.recyclerView.setVisibility(View.VISIBLE);
                }else {
                    Toast.makeText(MainActivity.this, "Error in getting data", Toast.LENGTH_SHORT).show();
                }
            }
        });
        viewModel.makeApiCall();
    }

}