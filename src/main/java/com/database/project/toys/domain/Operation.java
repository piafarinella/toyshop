package com.database.project.toys.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 * @author nahime.torres
 * @author pia.farinella
 *
 */
@Entity
public class Operation implements Serializable {

	private static final long serialVersionUID = 8827426002848213667L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String toy;

	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate date;

	private Float total;

	@OneToOne
	private User user;

	public Operation() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToy() {
		return toy;
	}

	public void setToy(Toy toy) {
		this.toy = "Name: " + toy.getName() + "\nDescription: " + toy.getDescription();
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Operation(Long id, String toy, LocalDate date, Float total, User user) {
		super();
		this.id = id;
		this.toy = toy;
		this.date = date;
		this.total = total;
		this.user = user;
	}

}
