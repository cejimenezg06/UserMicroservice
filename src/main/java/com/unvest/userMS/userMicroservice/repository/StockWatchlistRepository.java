package com.unvest.userMS.userMicroservice.repository;

import com.unvest.userMS.userMicroservice.entity.StockWatchlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockWatchlistRepository extends JpaRepository<StockWatchlist, Long> {
}
