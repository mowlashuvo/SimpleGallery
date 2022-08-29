package com.example.appinionsimplegalleryapp.network;

import androidx.lifecycle.MutableLiveData;

import com.example.appinionsimplegalleryapp.model.PhotoGalleryResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetroRepository {
    private RetroServiceInterface retroServiceInterface;

    public RetroRepository(RetroServiceInterface retroServiceInterface) {
        this.retroServiceInterface = retroServiceInterface;
    }

    public void makeApiCall(String client_id, MutableLiveData<List<PhotoGalleryResponse>> liveData) {
        Call<List<PhotoGalleryResponse>> call = retroServiceInterface.getImage(client_id);
        call.enqueue(new Callback<List<PhotoGalleryResponse>>() {
            @Override
            public void onResponse(Call<List<PhotoGalleryResponse>> call, Response<List<PhotoGalleryResponse>> response) {
                if (response.isSuccessful()){
                    liveData.postValue(response.body());
                }else {
                    liveData.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<List<PhotoGalleryResponse>> call, Throwable t) {
                liveData.postValue(null);
            }
        });
    }

}
