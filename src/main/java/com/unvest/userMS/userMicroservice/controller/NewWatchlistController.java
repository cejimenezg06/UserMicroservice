package com.unvest.userMS.userMicroservice.controller;

import com.unvest.userMS.userMicroservice.entity.NewWatchlist;
import com.unvest.userMS.userMicroservice.service.NewWatchlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NewWatchlistController {

    @Autowired
    private NewWatchlistService newWatchlistService;

    @GetMapping("/newWatchlists")
    public List<NewWatchlist> findAllNewWatchlists() {
        return newWatchlistService.findAllNewWatchlist();
    }

    @GetMapping("/newWatchlists/{id}")
    public NewWatchlist findNewWatchlistById(@PathVariable Long id) {
        return newWatchlistService.findNewWatchlistById(id);
    }

    @PostMapping("/saveNewWatchlist")
    public NewWatchlist saveNewWatchlist(@RequestBody NewWatchlist newWatchlist) {
        return newWatchlistService.saveNewWatchlist(newWatchlist);
    }

    @PutMapping("/updateNewWatchlist/{id}")
    public NewWatchlist updateNewWatchlist(@PathVariable Long id, @RequestBody NewWatchlist newWatchlist) {
        return newWatchlistService.updateNewWatchlist(id, newWatchlist);
    }

    @DeleteMapping("/deleteNewWatchlist/{id}")
    public void deleteNewWatchList(@PathVariable Long id) {
        newWatchlistService.deleteNewWatchlist(id);
    }

}
