package com.soebes.testguice;

public class ChargeResult {
    public final static ChargeResult DECLINE_NO_CREDIT = new ChargeResult("You have no Credit.", false);
    public final static ChargeResult SUCCESSFUL_TRANSACTION = new ChargeResult("Everything fine.", true);

    private boolean successful;
    private String declineMessage;

    public ChargeResult() {
        this.declineMessage = null;
        this.successful = false;
    }

    public ChargeResult(String declineMessage, boolean successful ) {
        this.declineMessage = declineMessage;
        this.successful = successful;
    }

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
