package com.TipsBorad.bean;

import java.util.Date;

public class User {
    private long id;
    private String username;
    private String password;
    private String realname;
    private Date birth;
    private String phone;
    private String address;

    public User(long id, String username, String password, String realname, Date birth, String phone, String address) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.birth = birth;
        this.phone = phone;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
