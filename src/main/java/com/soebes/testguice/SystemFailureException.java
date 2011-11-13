package com.soebes.testguice;

public class SystemFailureException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public SystemFailureException() {
        super();
    }

    public SystemFailureException(String message, Throwable cause) {
        super(message, cause);
    }

    public SystemFailureException(String message) {
        super(message);
    }

    public SystemFailureException(Throwable cause) {
        super(cause);
    }

}
