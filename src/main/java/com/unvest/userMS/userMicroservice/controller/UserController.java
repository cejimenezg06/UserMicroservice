package com.unvest.userMS.userMicroservice.controller;

import com.unvest.userMS.userMicroservice.entity.User;
import com.unvest.userMS.userMicroservice.error.UserNotFoundException;
import com.unvest.userMS.userMicroservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/user/{id}")
    public User findUserById(@PathVariable Long id) throws UserNotFoundException {
        return userService.findUserById(id);
    }

    @PostMapping("/saveUser")
    public User saveUser(@Valid @RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping("/updateUser/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User  user) {
        return updateUser(id, user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id) {
        deleteUser(id);
        return "User deleted: " + id;
    }


    // SPECIFIC QUERIES
    @GetMapping("/findByName/{name}")
    public Optional<User> findByName(@PathVariable String name) {
        return userService.findByName(name);
    }
    @GetMapping("/findByNameIgnoreCase/{name}")
    public Optional<User> findByNameIgnoreCase(@PathVariable String name) {
        return userService.findByNameIgnoreCase(name);
    }
    /*
    @GetMapping("/findUserByNameWithJPQL/{name}")
    public Optional<User> findUserByNameWithJPQL(@PathVariable String name) {
        return userService.findUserByNameWithJPQL(name);
    }
    */
}
