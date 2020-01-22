package com.realpacific.gameofthronesapp.ui.main.di;

import com.realpacific.gameofthronesapp.http.ApiServices;
import com.realpacific.gameofthronesapp.ui.main.MainContract;
import com.realpacific.gameofthronesapp.ui.main.Repository;
import com.realpacific.gameofthronesapp.ui.main.mvp.MainModel;
import com.realpacific.gameofthronesapp.ui.main.mvp.MainPresenter;
import com.realpacific.gameofthronesapp.ui.main.mvp.MainRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    @Provides
    public MainContract.Presenter providesPresenter(MainContract.Model model){
        return new MainPresenter(model);
    }

    @Provides
    public MainContract.Model providesModel(Repository repository){
        return new MainModel(repository);
    }

    @Provides
    public Repository providesRepository(ApiServices apiServices){
        return new MainRepository(apiServices);
    }

}
