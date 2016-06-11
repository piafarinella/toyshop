package com.database.project.toys.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.database.project.toys.domain.Toy;
import com.database.project.toys.dto.ToyDTO;
import com.database.project.toys.repository.ToyRepository;
import com.database.project.toys.service.ToyService;

/**
 * @author nahime.torres
 * @author pia.farinella
 *
 */

@Service
public class ToyServiceImp implements ToyService {

	@Autowired
	private ToyRepository toyRepository;

	public ToyServiceImp() {
		super();
	}

	@Override
	public Iterable<Toy> findAll() {
		return (toyRepository.findAll());
	}

	@Override
	public Toy persist(Toy toy) {

		return toyRepository.save(toy);
	}

	@Override
	public Toy get(long id) {
		return toyRepository.findOne(id);
	}

	@Override
	public void delete(long id) {
		toyRepository.delete(id);

	}

	@Override
	public synchronized boolean confirmBuy(Toy toy) {
		Integer stock = toy.getStock();
		if (stock > 0) {
			toy.setStock(stock - 1);
			persist(toy);
			return true;
		} else
			return false;

	}

	@Override
	public Toy persist(ToyDTO toyDTO) {
		Toy toy = new Toy(toyDTO.getId(), toyDTO.getName(), toyDTO.getPrice(), toyDTO.getStock(),
				toyDTO.getDescription(), toyDTO.getImageEncoded());
		return toyRepository.save(toy);
	}
}
