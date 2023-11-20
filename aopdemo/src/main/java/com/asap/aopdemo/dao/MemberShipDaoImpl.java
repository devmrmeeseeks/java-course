package com.asap.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MemberShipDaoImpl implements MembershipDao{

    @Override
    public boolean addSillyMember() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING A MEMBERSHIP ACCOUNT");
        return true;
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass() + ": I'm going to sleep now...");
    }
}
