package com.dsandley.models.general.users;

import com.dsandley.models.general.enums.Role;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class AuthUser {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String userName;
    @Enumerated(EnumType.STRING)
    private Role role;

    public AuthUser(int id, String firstName, String lastName, String email, String userName, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
