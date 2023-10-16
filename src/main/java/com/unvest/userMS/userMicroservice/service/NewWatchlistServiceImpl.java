package com.unvest.userMS.userMicroservice.service;

import com.unvest.userMS.userMicroservice.entity.NewWatchlist;
import com.unvest.userMS.userMicroservice.repository.NewWatchlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewWatchlistServiceImpl implements NewWatchlistService {

    @Autowired
    private NewWatchlistRepository newWatchlistRepository;

    @Override
    public List<NewWatchlist> findAllNewWatchlist() {
        return newWatchlistRepository.findAll();
    }

    @Override
    public NewWatchlist findNewWatchlistById(Long id) {
        return newWatchlistRepository.findById(id).get();
    }

    @Override
    public NewWatchlist saveNewWatchlist(NewWatchlist newWatchlist) {
        return newWatchlistRepository.save(newWatchlist);
    }

    @Override
    public NewWatchlist updateNewWatchlist(Long id, NewWatchlist newWatchlist) {
        NewWatchlist nwl = newWatchlistRepository.findById(id).get();
        return newWatchlistRepository.save(nwl);
    }

    @Override
    public void deleteNewWatchlist(Long id) {
        newWatchlistRepository.deleteById(id);
    }
}
