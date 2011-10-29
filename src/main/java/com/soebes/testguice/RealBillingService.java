package com.soebes.testguice;

import com.google.inject.Inject;

class RealBillingService implements BillingService {

    private final IAccountProcessor accountProcessor;
    private final ITransactionLog transactionLog;

    @Inject
    RealBillingService(IAccountProcessor processor, ITransactionLog transactionLog) {
        this.accountProcessor = processor;
        this.transactionLog = transactionLog;
    }

    @Override
    public Receipt chargeOrder(IOrder order, IAccount account) {
        try {
            ChargeResult result = accountProcessor.charge(order, account);
            transactionLog.logChargeResult(result);

            if (result.wasSuccessful()) {
                return Receipt.forSuccessfulCharge(order.getAmount());
            } else {
                return Receipt.forDeclinedCharge(result.getDeclineMessage());
            }
        } catch (SystemFailureException e) {
            transactionLog.logSystemFailure(e);
            return Receipt.forSystemFailure(e.getMessage());
        }
    }
}