package com.unvest.userMS.userMicroservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @NotBlank(message = "Please, you must fill this field")
    private String roleUser;

    private boolean activeUser;

    // JAAX Bidireccional (Elimina correcto, sirve la fk, ciclo finito, mala dirección)
    @JsonManagedReference  // Antepone sobre Perfil la traída de data, rompe el ciclo
    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "id_Perfil",
            referencedColumnName = "idPerfil"
    )
    //@JsonIgnoreProperties(value="user")
    private Perfil perfil;

    // Bidirectional (Elimina correctamente, Sirve pero no trae fk)
    /*
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Perfil perfil;
    */
    // Unidirectional


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
