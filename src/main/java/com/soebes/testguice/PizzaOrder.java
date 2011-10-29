package com.soebes.testguice;

public class PizzaOrder implements IOrder {

    private int amount;

    public PizzaOrder(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
