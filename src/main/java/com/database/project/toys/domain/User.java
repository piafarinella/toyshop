package com.database.project.toys.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author nahime.torres
 * @author pia.farinella
 *
 */

@Entity
@Table(name = "usuario")
public class User implements Serializable {

	private static final long serialVersionUID = -5298767902451520474L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true, nullable = false)
	private String userName;

	@Column(nullable = false)
	private String password;

	@Enumerated(EnumType.STRING)
	private Role role;

	@Column(nullable = false)
	private Boolean isActive;

	public User() {
		super();
	}

	public User(Long id, String username, String password, Role role, Boolean isActive) {
		super();
		this.id = id;
		this.userName = username.toLowerCase();
		this.password = new BCryptPasswordEncoder().encode(password);
		this.role = role;
		this.isActive = isActive;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return userName;
	}

	public void setUsername(String username) {
		this.userName = username.toLowerCase();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if (!password.isEmpty()) {
			this.password = new BCryptPasswordEncoder().encode(password);
		}
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public void changePermission() {
		if (role.equals(Role.ADMIN)) {
			role = Role.USER;
		} else {
			role = Role.ADMIN;
		}
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return userName;
	}

}
