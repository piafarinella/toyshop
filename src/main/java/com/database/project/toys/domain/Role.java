package com.database.project.toys.domain;

/**
 * @author nahime.torres
 * @author pia.farinella
 *
 */

public enum Role {

	USER("USER"), ADMIN("ADMIN");

	private String message;

	Role(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
