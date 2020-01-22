package com.realpacific.gameofthronesapp.ui.main.mvp;

import android.util.Log;

import com.realpacific.gameofthronesapp.entitiy.Characters;
import com.realpacific.gameofthronesapp.entitiy.GameOfThrones;
import com.realpacific.gameofthronesapp.http.ApiServices;
import com.realpacific.gameofthronesapp.ui.main.Repository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class MainRepository implements Repository {
    private ApiServices apiServices;
    private List<Characters> list;
    private long timestamp;
    private final long CACHE_TIME_OUT = 20000;

    public MainRepository(ApiServices apiServices) {
        this.apiServices = apiServices;
        list = new ArrayList<>();
        timestamp = System.currentTimeMillis();

    }

    private boolean isUpToDate(){
        return (timestamp - System.currentTimeMillis()) < CACHE_TIME_OUT;
    }

    @Override
    public Observable<GameOfThrones> getBooksFromNetwork() {
        return apiServices.getBooks("5");
    }

    @Override
    public Observable<Characters> getCharactersFromMemory() {
        if(isUpToDate()){

            Log.i("~~~", "getCharactersFromMemory: FROM MEM");
            return Observable.fromIterable(list);
        }else{
            list.clear();
            timestamp = System.currentTimeMillis();
            return Observable.empty();
        }
    }

    @Override
    public Observable<Characters> getCharactersFromNetwork() {
        Log.i("~~~", "getCharactersFromNetwork: FROM NETWORK");
       return getBooksFromNetwork().concatMap(new Function<GameOfThrones, Observable<String>>() {
           @Override
           public Observable<String> apply(GameOfThrones gameOfThrones) throws Exception {
               return Observable.fromIterable(gameOfThrones.getCharacters());
           }
       }).concatMap(new Function<String, ObservableSource<Characters>>() {
           @Override
           public ObservableSource<Characters> apply(String s) throws Exception {
               return apiServices.getCharacter(s.substring(s.lastIndexOf("/") + 1, s.length()));
           }
       }).doOnNext(new Consumer<Characters>() {
           @Override
           public void accept(Characters characters) throws Exception {
               list.add(characters);
           }
       });
    }

    @Override
    public Observable<Characters> getLatestNetworkResponse() {
        return getCharactersFromMemory().switchIfEmpty(getCharactersFromNetwork());
    }

}
