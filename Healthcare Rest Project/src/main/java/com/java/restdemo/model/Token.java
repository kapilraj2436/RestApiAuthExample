package com.java.restdemo.model;
import java.io.Serializable;

public class Token implements Serializable {

    private final String access_token;

    public Token(String access_token) {
        this.access_token = access_token;
    }

    public String getAccess_token() {
        return access_token;
    }
}