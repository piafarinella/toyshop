package com.database.project.toys.service;

import java.util.List;
import com.database.project.toys.domain.User;
import com.database.project.toys.dto.UserDTO;
import com.google.common.base.Optional;

/**
 * @author nahime.torres
 * @author pia.farinella
 *
 */
public interface UserService {

	Iterable<User> findAll();

	User persist(User user);

	User get(long id);

	void delete(long id);

	Optional<User> getUserByUserName(String userName);

	boolean notAllowed(String username);

	User persist(UserDTO userDTO);

	List<User> findActiveUsers();

}
