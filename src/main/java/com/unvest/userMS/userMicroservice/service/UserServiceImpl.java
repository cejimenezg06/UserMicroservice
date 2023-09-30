package com.unvest.userMS.userMicroservice.service;

import com.unvest.userMS.userMicroservice.entity.User;
import com.unvest.userMS.userMicroservice.error.UserNotFoundException;
import com.unvest.userMS.userMicroservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Long id) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new UserNotFoundException("User is not available");
        }
        return user.get();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        User userDb = userRepository.findById(id).get();
        return userRepository.save(userDb);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> findByName(String name) {
        return userRepository.findByNameUser(name);
    }

    @Override
    public Optional<User> findByNameIgnoreCase(String name) {
        return userRepository.findByNameUserIgnoreCase(name);
    }

    /*
    @Override
    public Optional<User> findUserByNameWithJPQL(String name) {
        return userRepository.findUserByNameWithJPQL(name);
    }
    */
}
