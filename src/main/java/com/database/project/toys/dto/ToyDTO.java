package com.database.project.toys.dto;

import java.io.File;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import com.database.project.toys.domain.Toy;

/**
 * @author nahime.torres
 * @author pia.farinella
 * 
 */
public class ToyDTO {
	private Long id;

	@NotEmpty
	private String name;

	@NotNull
	private Float price;

	@NotNull
	private Integer stock;

	@NotEmpty
	private String description;

	private String imageEncoded;
	private File image;

	public ToyDTO() {
		super();
	}

	public ToyDTO(Long id, String name, Float price, Integer stock, String description, String imageEncoded,
			File image) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.description = description;
		this.imageEncoded = imageEncoded;
		this.image = image;
	}

	public ToyDTO(Toy toy) {
		this.id = toy.getId();
		this.name = toy.getName();
		this.price = toy.getPrice();
		this.stock = toy.getStock();
		this.description = toy.getDescription();
		this.imageEncoded = toy.getImageEncoded();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageEncoded() {
		return imageEncoded;
	}

	public void setImageEncoded(String imageEncoded) {
		this.imageEncoded = imageEncoded;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

}
