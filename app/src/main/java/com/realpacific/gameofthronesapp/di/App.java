package com.realpacific.gameofthronesapp.di;

import android.app.Application;

import com.realpacific.gameofthronesapp.http.ApiModule;
import com.realpacific.gameofthronesapp.ui.main.di.MainModule;

public class App extends Application{
    ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .apiModule(new ApiModule())
                .mainModule(new MainModule())
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
