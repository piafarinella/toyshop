package com.database.project.toys.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.database.project.toys.domain.Operation;
import com.database.project.toys.repository.OperationRepository;
import com.database.project.toys.service.OperationService;

/**
 * @author nahime.torres
 * @author pia.farinella
 *
 */
@Service
public class OperationServiceImp implements OperationService {

	@Autowired
	private OperationRepository operationRepository;

	public OperationServiceImp() {
		super();
	}

	@Override
	public Iterable<Operation> findAll() {
		return (operationRepository.findAll());
	}

	@Override
	public Operation persist(Operation operation) {
		return operationRepository.save(operation);
	}

	@Override
	public Operation get(long id) {
		return operationRepository.findOne(id);
	}

	@Override
	public void delete(long id) {
		operationRepository.delete(id);

	}
}
