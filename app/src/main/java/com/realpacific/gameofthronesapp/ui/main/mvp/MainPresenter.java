package com.realpacific.gameofthronesapp.ui.main.mvp;

import com.realpacific.gameofthronesapp.entitiy.Characters;
import com.realpacific.gameofthronesapp.ui.main.MainContract;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter implements MainContract.Presenter {
    MainContract.View view;
    MainContract.Model model;

    public MainPresenter(MainContract.Model model) {
        this.model = model;
    }

    @Override
    public void setView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void loadData() {
        model.result().subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<Characters>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Characters characters) {
                view.updateData(characters);
            }

            @Override
            public void onError(Throwable e) {
                view.showSnackbar("error");
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void rxUnsubscribe() {

    }
}
