package org.vriesema.novi.rowingapp.payload;
/*
 * @created:  2021-07-06
 * @project:  rowingapp
 * @author:   bartvriesema
 */

public class AuthenticationResponse {
    private final String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
