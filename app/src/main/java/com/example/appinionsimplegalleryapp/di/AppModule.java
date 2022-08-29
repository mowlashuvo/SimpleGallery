package com.example.appinionsimplegalleryapp.di;

import com.example.appinionsimplegalleryapp.network.RetroServiceInterface;
import com.example.appinionsimplegalleryapp.utils.Constant;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {

    String baseURL = Constant.BASE_URL;

    @Singleton
    @Provides
    public RetroServiceInterface getRetroServiceInterface(Retrofit retrofit){
        return retrofit.create(RetroServiceInterface.class);
    }

    @Singleton
    @Provides
    public Retrofit getRetroInstance(){
        return new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


}
