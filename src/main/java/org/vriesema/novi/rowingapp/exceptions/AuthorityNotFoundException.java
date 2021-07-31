package org.vriesema.novi.rowingapp.exceptions;


public class AuthorityNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public AuthorityNotFoundException(String username) {
        super("Cannot find authority for username " + username);
    }
}
