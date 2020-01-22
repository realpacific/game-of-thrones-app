package com.realpacific.gameofthronesapp.ui.main;

import com.realpacific.gameofthronesapp.entitiy.Character;
import com.realpacific.gameofthronesapp.entitiy.GameOfThrones;

import io.reactivex.Observable;

public interface Repository {
    Observable<GameOfThrones> getBooksFromNetwork(int bookNumber);

    Observable<Character> getCharactersFromMemory();
    Observable<Character> getCharactersFromNetwork();
    Observable<Character> getLatestNetworkResponse();
}
