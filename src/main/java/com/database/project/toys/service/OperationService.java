package com.database.project.toys.service;

import com.database.project.toys.domain.Operation;

/**
 * @author nahime.torres
 * @author pia.farinella
 *
 */
public interface OperationService {

	Iterable<Operation> findAll();

	Operation persist(Operation operation);

	Operation get(long id);

	void delete(long id);

}
