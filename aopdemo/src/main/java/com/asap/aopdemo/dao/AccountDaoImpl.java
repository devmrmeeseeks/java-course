package com.asap.aopdemo.dao;

import com.asap.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao{
    private String name;
    private String serviceCode;

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public void addAccount(Account acount, boolean vipFlag) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + ": doWork()");
        return false;
    }

    @Override
    public String getName() {
        System.out.println(getClass() + ": getName()");
        return name;
    }

    @Override
    public void setName(String name) {
        System.out.println(getClass() + ": setName()");
        this.name = name;
    }

    @Override
    public String getServiceCode() {
        System.out.println(getClass() + ": getServiceCode()");
        return serviceCode;
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {
        if (tripWire) {
            throw new RuntimeException("No soup for you!!!");
        }

        ArrayList<Account> accounts = new ArrayList<>() {
            {
                add(new Account("John", "Silver"));
                add(new Account("Madhu", "Platinum"));
                add(new Account("Luca", "Gold"));
            }
        };

        return accounts;
    }

    @Override
    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
