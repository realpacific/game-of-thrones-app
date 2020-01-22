package com.realpacific.gameofthronesapp.ui.main;

import com.realpacific.gameofthronesapp.entitiy.Characters;
import com.realpacific.gameofthronesapp.entitiy.GameOfThrones;

import io.reactivex.Observable;

public interface Repository {
    Observable<GameOfThrones> getBooksFromNetwork();

    Observable<Characters> getCharactersFromMemory();
    Observable<Characters> getCharactersFromNetwork();
    Observable<Characters> getLatestNetworkResponse();
}
