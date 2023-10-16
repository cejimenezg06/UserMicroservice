package com.unvest.userMS.userMicroservice.service;

import com.unvest.userMS.userMicroservice.entity.StockWatchlist;
import com.unvest.userMS.userMicroservice.repository.StockWatchlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockWatchlistServiceImpl implements StockWatchlistService {

    @Autowired
    private StockWatchlistRepository stockWatchlistRepository;
    @Override
    public List<StockWatchlist> findAllStockWatchlist() {
        return stockWatchlistRepository.findAll();
    }

    @Override
    public StockWatchlist findStockWatchlistById(Long id) {
        return stockWatchlistRepository.findById(id).get();
    }

    @Override
    public StockWatchlist saveStockWatchlist(StockWatchlist stockWatchlist) {
        return stockWatchlistRepository.save(stockWatchlist);
    }

    @Override
    public StockWatchlist updateStockWatchlist(Long id, StockWatchlist stockWatchlist) {
        StockWatchlist swl = stockWatchlistRepository.findById(id).get();
        return stockWatchlistRepository.save(swl);
    }

    @Override
    public void deleteStockWatchlist(Long id) {
        stockWatchlistRepository.deleteById(id);
    }
}
