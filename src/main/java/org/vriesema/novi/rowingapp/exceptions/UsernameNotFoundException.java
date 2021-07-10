package org.vriesema.novi.rowingapp.exceptions;
/*
 * @created:  2021-07-06
 * @project:  rowingapp
 * @author:   bartvriesema
 */

public class UsernameNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UsernameNotFoundException(String username) {
        super("Cannot find user " + username);
    }

}
