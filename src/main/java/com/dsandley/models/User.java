package com.dsandley.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Daniel Sandley User model that will hold first and last name, email,
 *         and password & hash
 */
@Entity
@Table(name = "users")
public class User {

	//User Obj fields
	//TODO: add password and password hash fields

	/**
     * @param id - id of the User obj
     */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private final int id;
	/**
	 * @param firstName - firstName of the User obj
	 */
	private String firstName;
	/**
	 * @param firstName - firstName of the User obj
	 */
	private String lastName;
	/**
	 * @param firstName - firstName of the User obj
	 */
	private String email;

	//Constructors for the User class

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
	public User(final int idParam,
			    final String firstNameParam,
			    final String lastNameParam,
			    final String emailParam) {
		this.id = idParam;
		this.firstName = firstNameParam;
		this.lastName = lastNameParam;
		this.email = emailParam;
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
	 * @param firstNameParam - the new firstName for the specified user obj
	 */
	public void setFirstMame(final String firstNameParam) {
		this.firstName = firstNameParam;
	}

	/**
	 * @return lastName- the lastName of the user
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastNameParam - the new lastName for the specified user obj
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
	 * @param emailParam - the new email for the specified user obj
	 */
	public void setEmail(final String emailParam) {
		this.email = emailParam;
	}

}
