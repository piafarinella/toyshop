package com.database.project.toys.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 * @author nahime.torres
 * @author pia.farinella
 *
 */
@Entity
public class Toy implements Serializable {

	private static final long serialVersionUID = -6381497480633047703L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private Float price;

	@Column(nullable = false)
	private Integer stock;

	@Column(nullable = false)
	private String description;

	@Lob
	private String imageEncoded;

	public Toy() {
		super();
	}

	public Toy(Long id, String name, Float price, Integer stock, String description, String imageEncoded) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.description = description;

		this.imageEncoded = imageEncoded;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImageEncoded() {
		return imageEncoded;
	}

	public void setImageEncoded(String imageEncoded) {
		this.imageEncoded = imageEncoded;
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

	@Override
	public String toString() {
		return name + " " + description;
	}

}
