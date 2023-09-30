package com.unvest.userMS.userMicroservice.repository;

import com.unvest.userMS.userMicroservice.entity.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {
}
