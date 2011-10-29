package com.soebes.testguice;

public interface IAccount {

    int getBalance();

    int getLimit();

    String getName();

    ChargeResult charge(IOrder order);

}
