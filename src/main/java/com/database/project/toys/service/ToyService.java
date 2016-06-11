package com.database.project.toys.service;

import com.database.project.toys.domain.Toy;
import com.database.project.toys.dto.ToyDTO;

/**
 * @author nahime.torres
 * @author pia.farinella
 *
 */
public interface ToyService {

	Iterable<Toy> findAll();

	Toy persist(ToyDTO toyDTO);

	Toy get(long id);

	void delete(long id);

	boolean confirmBuy(Toy toy);

	Toy persist(Toy toy);

}
