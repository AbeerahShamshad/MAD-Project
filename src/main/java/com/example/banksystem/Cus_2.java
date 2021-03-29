package com.example.banksystem;

public class Cus_2 {
    private String id,name,password,email,Phone,Account_No,Ammt;
    public String token;
    public Cus_2(){
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

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public void setAccount_No(String account_No) {
        Account_No = account_No;
    }

    public void setAmmt(String ammt) {
        Ammt = ammt;
    }

    public Cus_2(String id, String name, String password, String email, String phone, String account_No, String ammt) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        Phone = phone;
        Account_No = account_No;
        Ammt = ammt;
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

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return Phone;
    }

    public String getAccount_No() {
        return Account_No;
    }

    public String getAmmt() {
        return Ammt;
    }
}
