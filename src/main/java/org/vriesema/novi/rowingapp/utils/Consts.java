package org.vriesema.novi.rowingapp.utils;


public final class Consts {

    public final static String SECRET_KEY = "secret"; // TODO Change secret key
    public final static int TOKEN_VALIDITY_DURATION = 1000 * 60 * 60 * 24;
    public final static int DEFAULT_DATE_INTERVAL = 14;

    /**
     * PRIVATE Only reference to these constants is allowed. The constructor cannot be used.
     */
    private Consts() {
        throw new AssertionError();
    }

}
