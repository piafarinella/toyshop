package com.database.project.toys.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.database.project.toys.domain.CurrentUser;
import com.database.project.toys.domain.User;
import com.database.project.toys.service.UserService;
import com.google.common.base.Optional;

/**
 * @author nahime.torres
 * @author pia.farinella
 *
 */

@Service
public class CurrentUserServiceImp implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public CurrentUser loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<User> user = userService.getUserByUserName(userName);
		return new CurrentUser(user.get());
	}

}
