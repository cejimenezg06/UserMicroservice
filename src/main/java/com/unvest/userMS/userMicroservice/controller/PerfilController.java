package com.unvest.userMS.userMicroservice.controller;

import com.unvest.userMS.userMicroservice.entity.Perfil;
import com.unvest.userMS.userMicroservice.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @GetMapping("/perfils")
    public List<Perfil> findAllPerfils() {
        return perfilService.findAllPerfils();
    }

    @GetMapping("/perfil/{id}")
    public Perfil findPerfilById(@PathVariable Long id) {
        return perfilService.findPerfilById(id);
    }

    @PostMapping("/savePerfil")
    public Perfil savePerfil(@RequestBody Perfil perfil) {
        return perfilService.savePerfil(perfil);
    }

    @PutMapping("/updatePerfil/{id}")
    public Perfil updatePerfil(@PathVariable Long id, @RequestBody Perfil perfil) {
        return perfilService.updatePerfil(perfil, id);
    }

    @DeleteMapping("/deletePerfil/{id}")
    public void deletePerfil(@PathVariable Long id) {
        perfilService.deletePerfilById(id);
    }

}
