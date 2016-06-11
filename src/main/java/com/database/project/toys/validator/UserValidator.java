package com.database.project.toys.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.database.project.toys.dto.UserDTO;
import com.database.project.toys.service.UserService;

/**
 * @author nahime.torres
 * @author pia.farinella
 *
 */

@Component
public class UserValidator implements Validator {

	private final UserService userService;

	@Autowired
	public UserValidator(UserService userService) {
		this.userService = userService;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return UserDTO.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		UserDTO user = (UserDTO) arg0;
		validatePasswords(errors, user);
		validateUsername(errors, user);
	}

	private void validatePasswords(Errors errors, UserDTO user) {
		if (!user.getPassword().equals(user.getPasswordRepeated())) {
			errors.rejectValue("password", "EmptyField", "Passwords don't match");

		}
	}

	private void validateUsername(Errors errors, UserDTO user) {
		if (userService.getUserByUserName(user.getUsername()).isPresent()) {

			errors.rejectValue("username", "EmptyField", "User with this username already exists");

		}
	}

}
