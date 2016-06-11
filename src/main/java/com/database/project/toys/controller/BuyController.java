package com.database.project.toys.controller;

import java.security.Principal;
import java.time.LocalDate;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.database.project.toys.domain.Operation;
import com.database.project.toys.domain.Toy;
import com.database.project.toys.service.OperationService;
import com.database.project.toys.service.ToyService;
import com.database.project.toys.service.UserService;

/**
 * @author nahime.torres
 * @author pia.farinella
 *
 */
@Controller
public class BuyController {
	@Autowired
	ToyService toyService;
	@Autowired
	OperationService operationService;
	@Autowired
	private UserService userService;

	public BuyController() {
		super();
	}

	@RequestMapping("/show")
	String list(Model model) {
		model.addAttribute("toys", toyService.findAll());
		return "toy/listtoshow";
	}

	@RequestMapping("/transactionHistory")
	String listOperations(Model model) {
		model.addAttribute("operations", operationService.findAll());
		return "operation/list";
	}

	@RequestMapping("/buy/{id}")
	String update(Model model, @PathVariable Long id) {
		model.addAttribute("toy", toyService.get(id));
		model.addAttribute("cero", 0);
		return "toy/buy";
	}

	@RequestMapping(value = "/buy/confirm/{id}")
	public String greetingSubmit(Model model, @PathVariable Long id, HttpServletRequest request) {
		Toy toy = toyService.get(id);
		if (toyService.confirmBuy(toy)) {
			Operation operation = new Operation();
			operation.setToy(toy);
			operation.setDate(LocalDate.now());
			operation.setTotal(toy.getPrice());
			Principal principal = request.getUserPrincipal();
			operation.setUser(userService.getUserByUserName(principal.getName()).get());
			operationService.persist(operation);
			return "confirmationSale";
		}
		return "redirect:/buy/{id}";

	}
}
