package com.unvest.userMS.userMicroservice.service;

import com.unvest.userMS.userMicroservice.entity.Perfil;

import java.util.List;

public interface PerfilService {

    List<Perfil> findAllPerfils();

    Perfil findPerfilById(Long id);

    Perfil savePerfil(Perfil perfil);

    Perfil updatePerfil(Perfil perfil, Long id);

    void deletePerfilById(Long id);
}
