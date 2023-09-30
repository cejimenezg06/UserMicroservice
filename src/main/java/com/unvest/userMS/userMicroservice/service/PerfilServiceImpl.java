package com.unvest.userMS.userMicroservice.service;

import com.unvest.userMS.userMicroservice.entity.Perfil;
import com.unvest.userMS.userMicroservice.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilServiceImpl implements PerfilService{

    @Autowired
    private PerfilRepository perfilRepository;

    @Override
    public List<Perfil> findAllPerfils() {
        return perfilRepository.findAll();
    }

    @Override
    public Perfil findPerfilById(Long id) {
        return perfilRepository.findById(id).get();
    }

    @Override
    public Perfil savePerfil(Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    @Override
    public Perfil updatePerfil(Perfil perfil, Long id) {
        Perfil perfilDB = perfilRepository.findById(id).get();
        return perfilRepository.save(perfilDB);
    }

    @Override
    public void deletePerfilById(Long id) {
        perfilRepository.deleteById(id);
    }
}
