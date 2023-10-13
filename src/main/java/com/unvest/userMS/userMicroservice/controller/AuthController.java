package com.unvest.userMS.userMicroservice.controller;

import com.unvest.userMS.userMicroservice.auth.JwtUtil;
import com.unvest.userMS.userMicroservice.entity.User;
import com.unvest.userMS.userMicroservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        // Authenticate user
        Optional<User> userOriginal = userService.findByName(user.getNameUser());

        if (userOriginal.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        if (!userOriginal.get().getPasswordUser().equals(user.getPasswordUser())) {
            return ResponseEntity.badRequest().build();
        }

        String token = jwtUtil.generateToken(user.getNameUser(), userOriginal.get().getRoleUser());
        return ResponseEntity.ok(token);
    }

    @GetMapping("/validate")
    public ResponseEntity<Object []> validateToken(@RequestParam("token") String token) {
        boolean isValid = jwtUtil.validateToken(token);
        String role = jwtUtil.extractRole(token);
        Object [] response = new Object[2];
        response[0] = isValid;
        response[1] = role;
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getID")
    public ResponseEntity<String> getID(@RequestParam("token") String token) {
        String ID = jwtUtil.extractUsername(token);
        return ResponseEntity.ok(ID);
    }
}
