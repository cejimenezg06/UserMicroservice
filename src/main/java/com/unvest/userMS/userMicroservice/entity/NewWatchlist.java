package com.unvest.userMS.userMicroservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_new_watchlist")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewWatchlist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idNew;

    private String descriptionNew;

}
