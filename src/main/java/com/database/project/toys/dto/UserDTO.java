package com.database.project.toys.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
import com.database.project.toys.domain.Role;

/**
 * @author nahime.torres
 * @author pia.farinella
 * 
 */
public class UserDTO {

	@Size(min = 4, max = 20, message = "Username must must contain between 4 and 20 characters")
	private String username = "";

	@Size(min = 6, max = 12, message = "Password must contain between 6 and 12 characters")
	private String password = "";

	@NotEmpty(message = "Please confirm your password")
	private String passwordRepeated = "";

	@NotNull
	private Role role = Role.USER;

	public UserDTO() {
		super();
	}

	public UserDTO(String username, String password, String passwordRepeated, Role role) {
		super();
		this.username = username;
		this.password = password;
		this.passwordRepeated = passwordRepeated;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordRepeated() {
		return passwordRepeated;
	}

	public void setPasswordRepeated(String passwordRepeated) {
		this.passwordRepeated = passwordRepeated;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
