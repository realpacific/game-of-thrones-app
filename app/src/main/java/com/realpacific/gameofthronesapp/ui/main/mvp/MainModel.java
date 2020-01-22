package com.realpacific.gameofthronesapp.ui.main.mvp;

import com.realpacific.gameofthronesapp.entitiy.Characters;
import com.realpacific.gameofthronesapp.ui.main.MainContract;
import com.realpacific.gameofthronesapp.ui.main.Repository;

import io.reactivex.Observable;

public class MainModel implements MainContract.Model{
    Repository repository;

    public MainModel(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<Characters> result() {
        return repository.getLatestNetworkResponse();
    }
}
