package com.dsandley.models.authentication;

public class AuthenticationRequest {

    /**
     * username for the request.
     */
    private String username;
    /**
     * password for the request.
     */
    private String password;

    /**
     * no args constructor - needed for serialization.
     */
    public AuthenticationRequest() {
        // TODO Auto-generated constructor stub
    }

    /**
     * full args constructor to generate the response.
     * @param usernameParam
     * @param passwordParam
     */
    public AuthenticationRequest(final String usernameParam,
            final String passwordParam) {
        this.username = usernameParam;
        this.password = passwordParam;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param usernameParam - the username to set
     */
    public void setUsername(final String usernameParam) {
        this.username = usernameParam;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param passwordParam - the password to set
     */
    public void setPassword(final String passwordParam) {
        this.password = passwordParam;
    }

}
