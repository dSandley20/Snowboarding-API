package com.dsandley.models.authentication;

import com.dsandley.models.general.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class AuthUserDetails implements UserDetails {

    private String userName;
    private String password;
    private int userId;
    private String firstName;
    private String lastName;
    private String email;

    public AuthUserDetails(User user){
        this.userId = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getFirstName();
        this.email = user.getEmail();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //TODO add roles column to table
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
