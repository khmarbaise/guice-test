package com.soebes.testguice;

public interface ITransactionLog {

    void log(String msg);

    void logChargeResult(ChargeResult result);

    void logSystemFailure(SystemFailureException failure);
}
