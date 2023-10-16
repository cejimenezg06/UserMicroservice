package com.unvest.userMS.userMicroservice.service;

import com.unvest.userMS.userMicroservice.entity.StockWatchlist;

import java.util.List;

public interface StockWatchlistService {

    List<StockWatchlist> findAllStockWatchlist();

    StockWatchlist findStockWatchlistById(Long id);

    StockWatchlist saveStockWatchlist(StockWatchlist stockWatchlist);

    StockWatchlist updateStockWatchlist(Long id ,StockWatchlist stockWatchlist);

    void deleteStockWatchlist(Long id);

}
