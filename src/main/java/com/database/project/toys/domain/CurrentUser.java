package com.database.project.toys.domain;

import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

/**
 * @author nahime.torres
 * @author pia.farinella
 *
 */

public class CurrentUser extends org.springframework.security.core.userdetails.User {

	private static final long serialVersionUID = 9099519562690467354L;

	private User user;

	Set<GrantedAuthority> authorities = null;

	public CurrentUser(User user) {
		super(user.getUsername(), user.getPassword(), true, true, true, true,
				AuthorityUtils.createAuthorityList(user.getRole().getMessage()));
		this.user = user;
	}

	public Long getId() {
		return user.getId();
	}

	public Role getRole() {
		return user.getRole();
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public boolean isEnabled() {
		return user.getIsActive().booleanValue();
	}

}