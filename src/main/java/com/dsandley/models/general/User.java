/**
 * holds all the models neccessary for the API
 */
package com.dsandley.models.general;

import javax.persistence.*;

/**
 * @author Daniel Sandley User model that will hold first and last name, email,
 *         and password & hash
 */
@Entity
@Table(name = "users")
public class User {

    // User Obj fields
    //todo: add password and password hash fields

    /**
     * @param id - id of the User obj
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    @Column(name = "user_name")
    private String userName;
    private String password;

    // Constructors for the User class

    /**
     * No args constructor for the User class.
     */
    public User() {
        this.id = 0;
    }

    /**
     * Constructor for the User class that takes full arguments.
     * @param idParam
     * @param firstNameParam
     * @param lastNameParam
     * @param emailParam
     */
    public User(final int idParam, final String firstNameParam,
            final String lastNameParam, final String emailParam, final String phoneParam, final String userNameParam, final String passwordParam) {
        this.id = idParam;
        this.firstName = firstNameParam;
        this.lastName = lastNameParam;
        this.email = emailParam;
        this.phone = phoneParam;
        this.userName = userNameParam;
        this.password = passwordParam;

    }

    // Getters and Setters
    /**
     * @return id - the id of the user
     */
    public int getId() {
        return id;
    }

    /**
     * @return firstName- the firstName of the user
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstNameParam
     *            - the new firstName for the specified user obj
     */
    public void setFirstName(final String firstNameParam) {
        this.firstName = firstNameParam;
    }

    /**
     * @return lastName- the lastName of the user
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastNameParam
     *            - the new lastName for the specified user obj
     */
    public void setLastName(final String lastNameParam) {
        this.lastName = lastNameParam;
    }

    /**
     * @return email- the email of the user
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param emailParam
     *            - the new email for the specified user obj
     */
    public void setEmail(final String emailParam) {
        this.email = emailParam;
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

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
