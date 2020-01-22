package com.realpacific.gameofthronesapp.http;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {
    final String BASE_URL = "https://anapioficeandfire.com/";
    @Provides
    @Singleton
    public HttpLoggingInterceptor providesHttpLoggingInterceptor(){
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @Provides
    @Singleton
    public OkHttpClient providesOkHttpClient(HttpLoggingInterceptor interceptor){
        return new OkHttpClient.Builder().addInterceptor(interceptor).build();
    }

    @Provides
    @Singleton
    public Retrofit providesRetrofit(String baseUrl, OkHttpClient client){
        return new Retrofit.Builder().client(client).addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseUrl).build();
    }

    @Provides
    @Singleton
    public ApiServices providesApiServices(){
        return providesRetrofit(BASE_URL, providesOkHttpClient(providesHttpLoggingInterceptor())).create(ApiServices.class);
    }
}
