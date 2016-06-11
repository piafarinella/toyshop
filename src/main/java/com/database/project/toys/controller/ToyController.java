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
import com.database.project.toys.dto.ToyDTO;
import com.database.project.toys.service.ToyService;
import com.database.project.toys.validator.ToyValidator;

/**
 * @author nahime.torres
 * @author pia.farinella
 *
 */

@Controller
public class ToyController {

	@Autowired
	ToyService toyService;

	public ToyController() {
		super();
	}

	@InitBinder("toy")
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(new ToyValidator());
	}

	@RequestMapping("/toys")
	String list(Model model) {
		model.addAttribute("toys", toyService.findAll());
		return "toy/list";
	}

	@RequestMapping("/toys/new")
	String create(Model model) {
		ToyDTO toy = new ToyDTO();
		model.addAttribute("toy", toy);
		return "toy/form";
	}

	@RequestMapping("/toys/edit/{id}")
	String update(Model model, @PathVariable Long id) {

		model.addAttribute("toy", new ToyDTO(toyService.get(id)));
		return "toy/form";
	}

	@RequestMapping("/toys/delete/{id}")
	String delete(Model model, @PathVariable Long id) {
		toyService.delete(id);
		return "redirect:/toys";
	}

	@RequestMapping(value = "/toy", method = RequestMethod.POST)
	public String greetingSubmit(@Valid @ModelAttribute("toy") ToyDTO toy, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("toy", toy);
			return "toy/form";
		} else {
			toyService.persist(toy);
			return "redirect:/toys";
		}
	}

}
