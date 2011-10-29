package com.soebes.testguice;

public class DatabaseTransactionLog implements ITransactionLog {

    @Override
    public void log(String msg) {
        System.out.println(this.getClass().getSimpleName() + " log(): " + msg);
    }

    @Override
    public void logChargeResult(ChargeResult result) {
        System.out.println(this.getClass().getSimpleName() + " logChargeResult(): " + result);
    }

    @Override
    public void logSystemFailure(SystemFailureException failure) {
        System.out.println(this.getClass().getSimpleName() + " logSystemFailure(): " + failure.getMessage());
    }

}
