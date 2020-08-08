package com.woniuxy.model;

import java.io.Serializable;

/**
 * 用户模型类
 */
public class User implements Serializable {
    private static final long serialVersionUID = -6363282530178824846L;

    private Integer id;
    private String email;
    private String password;

    /**
     * 构造器
     */
    public User() {
    }
    public User(Integer id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    /**
     * Getter && Setter
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
