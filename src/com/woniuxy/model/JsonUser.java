package com.woniuxy.model;

import java.io.Serializable;

public class JsonUser implements Serializable {
    private static final long serialVersionUID = 8273452100067934011L;

    private String email;
    private String password;
    private String remember;

    public JsonUser() {
    }

    public JsonUser(String email, String password, String remember) {
        this.email = email;
        this.password = password;
        this.remember = remember;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemember() {
        return remember;
    }

    public void setRemember(String remember) {
        this.remember = remember;
    }
}
