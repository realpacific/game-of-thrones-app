package com.realpacific.gameofthronesapp.di;

import com.realpacific.gameofthronesapp.http.ApiModule;
import com.realpacific.gameofthronesapp.ui.main.di.MainModule;
import com.realpacific.gameofthronesapp.ui.main.mvp.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, ApiModule.class, MainModule.class})
public interface ApplicationComponent {
    void inject(MainActivity activity);
}
