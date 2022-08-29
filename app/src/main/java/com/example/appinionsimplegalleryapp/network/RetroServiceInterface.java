package com.example.appinionsimplegalleryapp.network;

import com.example.appinionsimplegalleryapp.model.PhotoGalleryResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetroServiceInterface {
    @GET("/photos")
    Call<List<PhotoGalleryResponse>> getImage(@Query("client_id") String client_id);
//    zjFujXk4vi7ujrgE0ZSyTBv_b0jFHqMCbtMLBgxsK5U
//    AvO32LofVy1D_HrwpEUGQ7i9qaI43ZMiacvqjVAPKoY
}
