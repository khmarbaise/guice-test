package com.soebes.testguice;

public class ChargeResult {
    private boolean successful;
    private String declineMessage;

    public boolean wasSuccessful() {
        return successful;
    }

    public String getDeclineMessage() {
        return declineMessage;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public void setDeclineMessage(String declineMessage) {
        this.declineMessage = declineMessage;
    }

}
