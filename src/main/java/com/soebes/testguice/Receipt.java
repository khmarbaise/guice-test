package com.soebes.testguice;

public class Receipt {

    public static Receipt forSuccessfulCharge(int amount) {
        return null;
    }

    public static Receipt forDeclinedCharge(String message) {
        return null;
    }

    public static Receipt forSystemFailure(String message) {
        return null;
    }

}
