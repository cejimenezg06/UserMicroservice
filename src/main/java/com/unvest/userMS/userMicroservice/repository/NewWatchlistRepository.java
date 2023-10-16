package com.unvest.userMS.userMicroservice.repository;

import com.unvest.userMS.userMicroservice.entity.NewWatchlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewWatchlistRepository extends JpaRepository<NewWatchlist, Long> {
}
