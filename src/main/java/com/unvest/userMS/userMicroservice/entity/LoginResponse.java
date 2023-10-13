package com.unvest.userMS.userMicroservice.entity;

public class LoginResponse {
    private boolean success;
    private String role;


    public LoginResponse() {
        this.success = false;
        this.role = "";
    }

    public LoginResponse(String role) {
        this.success = true;
        this.role = role;
    }
}
