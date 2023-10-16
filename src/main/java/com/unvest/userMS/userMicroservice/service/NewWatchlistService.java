package com.unvest.userMS.userMicroservice.service;

import com.unvest.userMS.userMicroservice.entity.NewWatchlist;

import java.util.List;

public interface NewWatchlistService {

    List<NewWatchlist> findAllNewWatchlist();

    NewWatchlist findNewWatchlistById(Long id);

    NewWatchlist saveNewWatchlist(NewWatchlist newWatchlist);

    NewWatchlist updateNewWatchlist(Long id, NewWatchlist newWatchlist);

    void deleteNewWatchlist(Long id);
}
