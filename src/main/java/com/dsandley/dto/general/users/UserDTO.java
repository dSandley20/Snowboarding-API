package com.dsandley.dto.general.users;

import com.dsandley.models.general.enums.Role;

public class UserDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String password;
    private Role role;

    public UserDTO(String firstName, String lastName, String email, String userName, String password, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
        //check string to set role
        if(role.equals("user")){
            this.role = Role.USER;
        }else if (role.equals("admin")){
            this.role = Role.ADMIN;
        }else{
            this.role = Role.SUPER;
        }
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(String role) {
        if(role.equals("user")){
            this.role = Role.USER;
        }else if (role.equals("admin")){
            this.role = Role.ADMIN;
        }else{
            this.role = Role.SUPER;
        }
    }
}
