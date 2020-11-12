package com.example.heroku.requests;

import javax.validation.constraints.NotBlank;

public class RegisterRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    public RegisterRequest() {
    }

    public RegisterRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
