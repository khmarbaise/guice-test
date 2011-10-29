package com.soebes.testguice;

import org.testng.annotations.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.soebes.testguice.BillingModule;
import com.soebes.testguice.CreditCardAccount;
import com.soebes.testguice.IAccount;
import com.soebes.testguice.IOrder;
import com.soebes.testguice.PizzaOrder;
import com.soebes.testguice.RealBillingService;
import com.soebes.testguice.Receipt;

public class RealBillingServiceTest {

    @Test
    public void firstGuiceTest() {
        /*
         * Guice.createInjector() takes your Modules, and returns a new Injector
         * instance. Most applications will call this method exactly once, in their
         * main() method.
         */
        Injector injector = Guice.createInjector(new BillingModule());

        /*
         * Now that we've got the injector, we can build objects.
         */
        RealBillingService billingService = injector.getInstance(RealBillingService.class);

        // The Pizza is worth 100 units
        IOrder order = new PizzaOrder(100);

        // The credit card has 1000 units available as limit (credit)
        // current balance 250 units
        IAccount account = new CreditCardAccount("The Name", 1000, 250);

        Receipt receipt = billingService.chargeOrder(order, account);
    }
}
