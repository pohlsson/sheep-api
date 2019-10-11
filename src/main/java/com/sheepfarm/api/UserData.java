package com.sheepfarm.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserData {
    private String username;

    private String password;

    public UserData() {

    }

    public UserData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @JsonProperty
    public String getUsername() {
        return username;
    }

    @JsonProperty
    public String getPassword() {
        return password;
    }
}
