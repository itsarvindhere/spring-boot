package com.example.aopdemo.dao;


import com.example.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

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
}
