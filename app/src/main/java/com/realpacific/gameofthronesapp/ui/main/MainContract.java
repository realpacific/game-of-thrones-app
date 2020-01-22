package com.realpacific.gameofthronesapp.ui.main;

import com.realpacific.gameofthronesapp.entitiy.Characters;

import io.reactivex.Observable;

public class MainContract {
    public interface View{
        void updateData(Characters character);
        void showSnackbar(String message);
    }

    public interface Model{
        Observable<Characters> result();
    }

    public interface Presenter{
        void setView(View view);
        void loadData();
        void rxUnsubscribe();
    }
}
