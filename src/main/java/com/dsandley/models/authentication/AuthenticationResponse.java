package com.dsandley.models.authentication;

import com.dsandley.models.general.users.AuthUser;

public class AuthenticationResponse {

    /**
     * the actual token value.
     */
    private final String jwt;
    private final AuthUser user;

    /**
     * @param jwtParam
     */
    public AuthenticationResponse(final String jwtParam, final AuthUser user) {
        this.jwt = jwtParam;
        this.user = user;
    }

    /**
     * @return the jwt
     */
    public String getJwt() {
        return jwt;
    }
    public AuthUser getUser() {return user;}

}
