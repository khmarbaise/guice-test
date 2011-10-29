package com.soebes.testguice;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

@Test
public class CreditCardAccountTest {

    public void basicTest() {
        CreditCardAccount creditCard = new CreditCardAccount("American Express", 1500, 5000);
        assertNotNull(creditCard);
        assertEquals(creditCard.getName(), "American Express");
        assertEquals(creditCard.getCreditLimit(), 1500);
        assertEquals(creditCard.getBalance(), 5000);
    }

    public void usualChargeTest() {
        CreditCardAccount creditCard = new CreditCardAccount("Eurocard", 1500, 5000);
        assertNotNull(creditCard);

        IOrder order = new PizzaOrder(100);
        ChargeResult result = creditCard.charge(order);

        assertTrue(result.wasSuccessful());
        assertEquals(creditCard.getBalance(), 4900);
    }

    public void chargePartiallyAsCreditTest() {
        CreditCardAccount creditCard = new CreditCardAccount("Eurocard", 1500, 50);
        assertNotNull(creditCard);

        IOrder order = new PizzaOrder(100);
        ChargeResult result = creditCard.charge(order);

        assertTrue(result.wasSuccessful());
        assertEquals(creditCard.getBalance(), -50);
        assertEquals(creditCard.getCreditLimit(), 1500);
    }

    public void chargeFullyAsCreditTest() {
        CreditCardAccount creditCard = new CreditCardAccount("Eurocard", 1500, 0);
        assertNotNull(creditCard);

        IOrder order = new PizzaOrder(100);
        ChargeResult result = creditCard.charge(order);

        assertTrue(result.wasSuccessful());
        assertEquals(creditCard.getBalance(), -100);
        assertEquals(creditCard.getCreditLimit(), 1500);
    }

    public void chargeAsFullyAsCreditReachingTheLimitTest() {
        CreditCardAccount creditCard = new CreditCardAccount("Eurocard", 1500, -1400);
        assertNotNull(creditCard);

        IOrder order = new PizzaOrder(100);
        ChargeResult result = creditCard.charge(order);

        assertTrue(result.wasSuccessful());
        assertEquals(creditCard.getBalance(), -1500);
        assertEquals(creditCard.getCreditLimit(), 1500);
    }

    public void chargeOrderAlreadyReachedCreditLimitTest() {
        CreditCardAccount creditCard = new CreditCardAccount("Eurocard", 1500, -1500);
        assertNotNull(creditCard);

        IOrder order = new PizzaOrder(1);
        ChargeResult result = creditCard.charge(order);

        assertFalse(result.wasSuccessful());
        assertEquals(result.getDeclineMessage(), "The limit of your card has been reached.");
    }

    public void chargeOrderWhichWillReachTheCreditLimitTest() {
        CreditCardAccount creditCard = new CreditCardAccount("Eurocard", 1500, -1490);
        assertNotNull(creditCard);

        IOrder order = new PizzaOrder(100);
        ChargeResult result = creditCard.charge(order);

        assertFalse(result.wasSuccessful());
        assertEquals(result.getDeclineMessage(), "The limit of your card would be exceeded based on the given order.");
    }

}
