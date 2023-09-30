package com.unvest.userMS.userMicroservice.repository;

import com.unvest.userMS.userMicroservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByNameUser(String name);

    Optional<User> findByNameUserIgnoreCase(String name);

    /*
    @Query("SELECT u FROM USER u WHERE u.nameUser = :name")
    Optional<User> findUserByNameUserWithJPQL(String name);
    */
}
