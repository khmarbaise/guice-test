package com.soebes.testguice;

import com.google.inject.AbstractModule;

public class BillingModule extends AbstractModule {
    @Override
    protected void configure() {

        /*
         * This tells Guice that whenever it sees a dependency on a
         * ITransactionLog, it should satisfy the dependency using a
         * DatabaseTransactionLog.
         */
        bind(ITransactionLog.class).to(DatabaseTransactionLog.class);

        /*
         * Similarly, this binding tells Guice that when ICreditCardProcessor is
         * used in a dependency, that should be satisfied with a
         * PaypalCreditCardProcessor.
         */
        bind(IAccountProcessor.class).to(CreditCardProcessor.class);
    }
}
