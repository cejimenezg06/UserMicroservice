package com.unvest.userMS.userMicroservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_perfil")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPerfil;

    private String namePerfil;

    /*
    private String lastNamePerfil;
    private String emailPerfil;
    private String phonePerfil;
    private String imagePerfil;
    */

    @OneToOne(
            mappedBy = "perfil",
            fetch = FetchType.EAGER
    )
    private User user;

}
