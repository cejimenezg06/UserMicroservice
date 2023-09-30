package com.unvest.userMS.userMicroservice.service;

import com.unvest.userMS.userMicroservice.entity.User;
import com.unvest.userMS.userMicroservice.error.UserNotFoundException;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAllUsers();

    User findUserById(Long id) throws UserNotFoundException;

    User saveUser(User user);

    User updateUser(Long id, User user);

    void deleteUser(Long id);


    // Specific Queries
    Optional<User> findByName(String name);
    Optional<User> findByNameIgnoreCase(String name);

    //Optional<User> findUserByNameWithJPQL(String name);


}
