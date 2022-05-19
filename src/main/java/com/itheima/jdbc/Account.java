package com.itheima.jdbc;

public class Account {
    private int id;
    private String username;
    private Double balance;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String password) {
        this.username = password;
    }
    public Double getBalance() {
        return balance;
    }
    public void setBalance(Double balance) {
        this.balance = balance;
    }
    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", password='" + username + '\'' +
                ", balance=" + balance +
                '}';
    }
}
