package org.vriesema.novi.rowingapp.utils;
/*
 * @created:  2021-07-11
 * @project:  rowingapp
 * @author:   bartvriesema
 */

public final class Consts {

    // PRIVATE
    // Only reference to these constants is allowed. The constructor cannot be used.
    private Consts() {
        throw new AssertionError();
    }

    public final static String SECRET_KEY = "secret"; // TODO Change secret key

    public final static int TOKEN_VALIDITY_DURATION = 1000 * 60 * 60 * 24;

}
