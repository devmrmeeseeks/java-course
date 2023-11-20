package com.asap.aopdemo.dao;

import com.asap.aopdemo.Account;

import java.util.List;

public interface AccountDao {
    List<Account> findAccounts();
    void addAccount(Account acount, boolean vipFlag);
    boolean doWork();
    void setName(String name);
    void setServiceCode(String serviceCode);
    String getName();
    String getServiceCode();

    List<Account> findAccounts(boolean tripWire);
}
