package com.database.project.toys.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.database.project.toys.dto.ToyDTO;
import com.google.common.io.Files;

/**
 * @author nahime.torres
 * @author pia.farinella
 *
 */
@Component
public class ToyValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ToyDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object toyObj, Errors errors) {
		ToyDTO toy = (ToyDTO) toyObj;
		if (toy.getPrice() == null) {
			errors.rejectValue("price", "EmptyField", "Price is required");
		} else {
			if (toy.getPrice() < 0) {
				errors.rejectValue("price", "EmptyField", "Price can't be negative");
			}
		}
		if (toy.getStock() == null) {
			errors.rejectValue("stock", "EmptyField", "Stock is required");
		} else {
			if (toy.getStock() < 0) {
				errors.rejectValue("stock", "EmptyField", "Stock can't be negative");
			}
		}

		String extension = (Files.getFileExtension(toy.getImage().getName()));
		if (!extension.isEmpty()) {

			if (!extension.equalsIgnoreCase("jpg")) {
				errors.rejectValue("image", "Wrong Exension",
						"The extension is not allowed " + extension + ". Only jpg files.");
			}
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Name field is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "", "Description is required.");
	}

}
