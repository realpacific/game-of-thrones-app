package com.realpacific.gameofthronesapp.ui.main.mvp;

import android.util.Log;

import com.realpacific.gameofthronesapp.entitiy.Character;
import com.realpacific.gameofthronesapp.entitiy.GameOfThrones;
import com.realpacific.gameofthronesapp.http.ApiServices;
import com.realpacific.gameofthronesapp.ui.main.Repository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class MainRepository implements Repository {
    private ApiServices apiServices;
    private List<Character> list;
    private long timestamp;
    private final long CACHE_TIME_OUT = 20000;

    public MainRepository(ApiServices apiServices) {
        this.apiServices = apiServices;
        list = new ArrayList<>();
        timestamp = System.currentTimeMillis();

    }

    private boolean isUpToDate() {
        return (timestamp - System.currentTimeMillis()) < CACHE_TIME_OUT;
    }

    @Override
    public Observable<GameOfThrones> getBooksFromNetwork(int bookNumber) {
        return apiServices.getBooks(String.valueOf(bookNumber));
    }

    @Override
    public Observable<Character> getCharactersFromMemory() {
        if (isUpToDate()) {
            Log.i("~~~", "getCharactersFromMemory: FROM MEM");
            return Observable.fromIterable(list);
        } else {
            list.clear();
            timestamp = System.currentTimeMillis();
            return Observable.empty();
        }
    }

    @Override
    public Observable<Character> getCharactersFromNetwork() {
        Log.i("~~~", "getCharactersFromNetwork: FROM NETWORK");
        return Observable.fromArray(1, 2, 3, 4, 5)
                .flatMap(this::getBooksFromNetwork)
                .concatMap(got -> Observable.fromIterable(got.getCharacters()))
                .concatMap(url -> apiServices.getCharacter(url.substring(url.lastIndexOf("/"))))
                .filter(character -> !character.getName().isEmpty())
                .doOnNext(character -> list.add(character));
    }

    @Override
    public Observable<Character> getLatestNetworkResponse() {
        return getCharactersFromMemory().switchIfEmpty(getCharactersFromNetwork());
    }

}
