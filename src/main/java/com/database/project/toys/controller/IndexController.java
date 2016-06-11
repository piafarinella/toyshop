package com.database.project.toys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author nahime.torres
 * @author pia.farinella
 *
 */

@Controller
public class IndexController {

	public IndexController() {
		super();

	}

	@RequestMapping(value = "/")
	public String index() {

		return "home";
	}

	@RequestMapping("/403")
	public String accessDenied() {
		return "accessDenied";
	}

	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}

}