package com.unvest.userMS.userMicroservice.repository;

import com.unvest.userMS.userMicroservice.entity.Perfil;
import com.unvest.userMS.userMicroservice.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PerfilRepositoryTest {

    @Autowired
    private PerfilRepository perfilRepository;

    @Test
    public void findAllPerfils() {
        List<Perfil> perfils = perfilRepository.findAll();
        System.out.println("perfils = " + perfils);
    }
}