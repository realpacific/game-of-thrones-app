package com.realpacific.gameofthronesapp.http;

import com.realpacific.gameofthronesapp.entitiy.Characters;
import com.realpacific.gameofthronesapp.entitiy.GameOfThrones;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiServices {

    @GET("/api/books/{bookno}")
    Observable<GameOfThrones> getBooks(@Path("bookno") String bookNo);

    @GET("/api/characters/{character}")
    Observable<Characters> getCharacter(@Path("character") String character);
}
