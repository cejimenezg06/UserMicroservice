package com.unvest.userMS.userMicroservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_stockWatchlist")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockWatchlist {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private Long idStockWatchlist;
}
