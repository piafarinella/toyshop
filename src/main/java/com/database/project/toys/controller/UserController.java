package com.database.project.toys.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.database.project.toys.domain.User;
import com.database.project.toys.dto.UserDTO;
import com.database.project.toys.service.UserService;
import com.database.project.toys.validator.UserValidator;

/**
 * @author nahime.torres
 * @author pia.farinella
 *
 */

@Controller
public class UserController {

	private final UserService userService;
	private final UserValidator userCreateFormValidator;

	@Autowired
	public UserController(UserService userService, UserValidator userCreateFormValidator) {
		this.userService = userService;
		this.userCreateFormValidator = userCreateFormValidator;
	}

	@InitBinder("user")
	private void initBinder(WebDataBinder binder) {
		binder.addValidators(userCreateFormValidator);
	}

	@RequestMapping("/users")
	String list(Model model) {
		model.addAttribute("users", userService.findActiveUsers());
		return "user/list";
	}

	@RequestMapping("/users/delete/{id}")
	String delete(Model model, @PathVariable Long id) {
		userService.delete(id);
		return "redirect:/users";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@Valid @ModelAttribute("user") UserDTO user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("user", user);
			return "user/register";
		} else {
			userService.persist(user);
			model.addAttribute("mensaje", "The registration process was succesful");
			return "redirect:/login?registrarion";
		}
	}

	@RequestMapping("/users/changePermission/{id}")
	String changePermissions(Model model, @PathVariable Long id) {
		User user = userService.get(id);
		user.changePermission();
		userService.persist(user);
		return "redirect:/users";
	}

	@RequestMapping("/register")
	public String showRegister(Model model) {
		UserDTO user = new UserDTO();
		model.addAttribute("user", user);
		return "user/register";
	}
}
