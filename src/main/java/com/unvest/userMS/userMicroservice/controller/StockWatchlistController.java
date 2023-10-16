package com.unvest.userMS.userMicroservice.controller;

import com.unvest.userMS.userMicroservice.entity.StockWatchlist;
import com.unvest.userMS.userMicroservice.service.StockWatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StockWatchlistController {

    @Autowired
    private StockWatchlistService stockWatchlistService;

    @GetMapping("/stockWatchlists")
    public List<StockWatchlist> findAllStockWatchlist() {
        return stockWatchlistService.findAllStockWatchlist();
    }

    @GetMapping("/stockWatchlist/{id}")
    public StockWatchlist findStockWatchlistById(@PathVariable Long id) {
        return stockWatchlistService.findStockWatchlistById(id);
    }

    @PostMapping("/saveStockWatchlist")
    public StockWatchlist saveStockWatchlist(@RequestBody StockWatchlist stockWatchlist) {
        return stockWatchlistService.saveStockWatchlist(stockWatchlist);
    }

    @PutMapping("/updateStockWatchlist/{id}")
    public StockWatchlist updateStockWatchlist(@PathVariable Long id, @RequestBody StockWatchlist stockWatchlist) {
        return stockWatchlistService.updateStockWatchlist(id, stockWatchlist);
    }

    @DeleteMapping("/deleteStockWatchlist")
    public void deleteStockWatchlist(@PathVariable Long id) {
        stockWatchlistService.deleteStockWatchlist(id);
    }

}
