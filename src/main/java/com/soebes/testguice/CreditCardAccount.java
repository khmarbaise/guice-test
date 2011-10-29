package com.soebes.testguice;

public class CreditCardAccount implements IAccount {

    private String name;
    private int creditLimit;
    private int balance;

    public CreditCardAccount(String name, int creditLimit, int balance) {
        this.name = name;
        this.creditLimit = creditLimit;
        this.setBalance(balance);
    }

    @Override
    public String getName() {
        return name;
    }

    public void setCreditLimit(int creditLimit) {
        this.creditLimit = creditLimit;
    }

    public int getCreditLimit() {
        return creditLimit;
    }

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public int getLimit() {
        return creditLimit;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean havingCredit() {
        if (getCreditLimit() > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public ChargeResult charge(IOrder order) {
        ChargeResult result = new ChargeResult();
        result.setSuccessful(false);

        if (getBalance() <= 0) {
            if (havingCredit()) {
                // Yes we are allowed to charge as a credit..
                chargeCredit(order, result);
            } else {
                result.setDeclineMessage("You have no credit.");
            }
        } else {
            if (getBalance() >= order.getAmount()) {
                setBalance(getBalance() - order.getAmount());
                result.setSuccessful(true);
            } else {
                if (havingCredit()) {
                    // Yes we are allowed to charge as a credit..
                    chargeCredit(order, result);
                } else {
                    result.setDeclineMessage("You have no credit.");
                }
            }
        }

        return result;
    }

    private void chargeCredit(IOrder order, ChargeResult result) {
        if (Math.abs(getBalance()) >= getCreditLimit()) {
            result.setDeclineMessage("The limit of your card has been reached.");
        } else {
            if (Math.abs(getBalance()) + order.getAmount() <= getCreditLimit()) {
                // There is enough credit available.
                result.setSuccessful(true);
                setBalance(getBalance() - order.getAmount());
            } else {
                result.setDeclineMessage("The limit of your card would be exceeded based on the given order.");
            }
        }
    }

}
