package com.example.aopdemo.dao;


import com.example.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private String name;
    private String serviceCode;

    @Override
    public void addAccount() {
        System.out.println(getClass() + ": DOING DB WORK: ADDING AN ACCOUNT WITHOUT TAKING ANY ARGUMENTS");
    }

    @Override
    public void addAccount(Account account) {
        System.out.println(getClass() + ": DOING DB WORK: ADDING AN ACCOUNT BY TAKING ACCOUNT AS ARGUMENT");
    }

    @Override
    public void addAccount(Account account, boolean vip) {
        System.out.println(getClass() + ": DOING DB WORK: ADDING AN ACCOUNT BY TAKING ACCOUNT & VIP AS ARGUMENT");
    }

    public String getName() {
        System.out.println(getClass() + ": getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": setServiceCode()");
        this.serviceCode = serviceCode;
    }

    @Override
    public String toString() {
        return "AccountDAOImpl{" +
                "name='" + name + '\'' +
                ", serviceCode='" + serviceCode + '\'' +
                '}';
    }
}
