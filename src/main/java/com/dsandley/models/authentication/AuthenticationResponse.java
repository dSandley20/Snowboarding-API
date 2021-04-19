package com.dsandley.models.authentication;

public class AuthenticationResponse {

    /**
     * the actual token value.
     */
    private final String jwt;

    /**
     * @param jwtParam
     */
    public AuthenticationResponse(final String jwtParam) {
        this.jwt = jwtParam;
    }

    /**
     * @return the jwt
     */
    public String getJwt() {
        return jwt;
    }


}
