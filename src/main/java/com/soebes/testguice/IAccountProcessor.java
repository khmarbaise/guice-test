package com.soebes.testguice;

public interface IAccountProcessor {

    /**
     * This will charge the order from the account.
     * 
     * @param IOrder
     *            The order which should be processed.
     * @param IAccount
     *            The account from the order should be charged.
     * @return ChargeResult will inform you if it everything is gone well or not.
     */
    ChargeResult charge(IOrder order, IAccount account) throws SystemFailureException;
}
