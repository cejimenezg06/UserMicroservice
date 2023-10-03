package com.unvest.userMS.userMicroservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_perfil")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "user")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPerfil;

    private String namePerfil;


    private String lastNamePerfil;
    private String emailPerfil;
    private String phonePerfil;
    private String imagePerfil;


    // JAAX Bidireccional (Incorrect deleting, fk ok, finite loop, bad direction)
    @JsonBackReference   // Inhibe la recepción de data de parte de la otra tabla (se vuelve recesiva). Rompe el ciclo
    @OneToOne(
            mappedBy = "perfil",
            fetch = FetchType.EAGER
    )
    //@JsonIgnoreProperties("perfil")
    private User user;


    // Bidirectional T (Correct deleting, bad fk)
    /*
    @JoinColumn(name = "id_user")
    @OneToOne(
            fetch = FetchType.LAZY
    )
    private User user;
    */

}
