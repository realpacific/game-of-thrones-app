package com.realpacific.gameofthronesapp.ui.main;

import com.realpacific.gameofthronesapp.entitiy.Character;

import io.reactivex.Observable;

public class MainContract {
    public interface View{
        void updateData(Character character);
        void showSnackbar(String message);
    }

    public interface Model{
        Observable<Character> result();
    }

    public interface Presenter{
        void setView(View view);
        void loadData();
        void rxUnsubscribe();
    }
}
