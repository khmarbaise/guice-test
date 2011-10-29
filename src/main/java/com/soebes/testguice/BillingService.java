package com.soebes.testguice;

public interface BillingService {

    /**
     * The chargeOrder will charge the order from the account.
     * 
     * @param order
     * @param account
     * @return
     */
    Receipt chargeOrder(IOrder order, IAccount account);

}
