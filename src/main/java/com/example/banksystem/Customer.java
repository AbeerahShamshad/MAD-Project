package com.example.banksystem;

import java.io.Serializable;

public class Customer  implements Serializable  {
    private String id,name,password,email,Phone,Account_No,Ammt;

    public Customer() {

    }

    public Customer(String id, String name, String password, String account_No, String email, String ammt, String phone) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.Account_No = account_No;
        this.email = email;
        this.Ammt = ammt;
        this.Phone = phone;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccount_No(String account_No) {
        Account_No = account_No;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAmmt(String ammt) {
        Ammt = ammt;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getAccount_No() {
        return Account_No;
    }

    public String getEmail() {
        return email;
    }

    public String getAmmt() {
        return Ammt;
    }

    public String getPhone() {
        return Phone;
    }
}
