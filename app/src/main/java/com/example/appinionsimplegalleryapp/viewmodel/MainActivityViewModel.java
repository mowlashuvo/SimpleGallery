package com.example.appinionsimplegalleryapp.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.appinionsimplegalleryapp.model.PhotoGalleryResponse;
import com.example.appinionsimplegalleryapp.network.RetroRepository;
import com.example.appinionsimplegalleryapp.network.RetroServiceInterface;
import com.example.appinionsimplegalleryapp.utils.Constant;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainActivityViewModel extends ViewModel {
    MutableLiveData<List<PhotoGalleryResponse>> liveData;

    @Inject
    RetroServiceInterface retroServiceInterface;

    @Inject
    public MainActivityViewModel() {
        this.liveData = new MutableLiveData();
    }

    public MutableLiveData<List<PhotoGalleryResponse>> getLiveData() {
        return liveData;
    }

    public void makeApiCall(){
        RetroRepository retroRepository = new RetroRepository(retroServiceInterface);
        retroRepository.makeApiCall(Constant.CLIENT_ID, liveData);
    }

}
