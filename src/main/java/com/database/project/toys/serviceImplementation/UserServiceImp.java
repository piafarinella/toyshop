package com.database.project.toys.serviceImplementation;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.database.project.toys.domain.User;
import com.database.project.toys.dto.UserDTO;
import com.database.project.toys.repository.UserRepository;
import com.database.project.toys.service.UserService;
import com.google.common.base.Optional;

/**
 * @author nahime.torres
 * @author pia.farinella
 *
 */
@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepository;

	public UserServiceImp() {
		super();
	}

	@Override
	public Iterable<User> findAll() {
		return (userRepository.findAll());
	}

	@Override
	public List<User> findActiveUsers() {
		List<User> users = (List<User>) userRepository.findAll();
		return users.stream().filter(user -> user.getIsActive()).collect(Collectors.toList());
	}

	@Override
	public User persist(User user) {

		return userRepository.save(user);
	}

	@Override
	public User persist(UserDTO userDTO) {
		User user = new User();
		user.setPassword(userDTO.getPassword());
		user.setUsername(userDTO.getUsername());
		user.setRole(userDTO.getRole());
		user.setIsActive(true);
		return userRepository.save(user);
	}

	@Override
	public User get(long id) {
		return userRepository.findOne(id);
	}

	@Override
	public void delete(long id) {
		User user = userRepository.findOne(id);
		user.setIsActive(false);
		userRepository.save(user);

	}

	@Override
	public Optional<User> getUserByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

	@Override
	public boolean notAllowed(String userName) {
		if (this.getUserByUserName(userName) != null) {
			return true;
		} else {
			return false;
		}
	}
}
