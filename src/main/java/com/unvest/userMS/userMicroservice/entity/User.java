package com.unvest.userMS.userMicroservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Entity
@Table(name = "tbl_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "perfil")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUser;

    @NotBlank(message = "Please, you must fill this field")
    @Length(min = 1, max = 10)
    private String nameUser;

    @NotBlank(message = "Please, you must fill this field")
    @Length(min = 1, max = 10)
    private String passwordUser;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "id_perfil",
            referencedColumnName = "idPerfil"
    )
    private Perfil perfil;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "id_user",
            referencedColumnName = "idUser"
    )
    private List<StockWatchlist> stockWatchlistList;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "id_user",
            referencedColumnName = "idUser"
    )
    private List<NewWatchlist> newWatchlistsList;
}
