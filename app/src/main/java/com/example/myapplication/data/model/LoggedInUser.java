package com.example.myapplication.data.model;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class LoggedInUser {

    private String email;
    private Token token;

    public LoggedInUser(String email, Token token) {
        this.email = email;
        this.token = token;
    }

    public Token getToken(){ return token; }

    public String getEmail(){ return email; }

}
