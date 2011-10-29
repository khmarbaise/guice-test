package com.soebes.testguice;

public class CreditCardProcessor implements IAccountProcessor {

    @Override
    public ChargeResult charge(IOrder order, IAccount creditCard) {
        System.out.println(this.getClass().getSimpleName() + " charge()");
        return creditCard.charge(order);
    }
}
