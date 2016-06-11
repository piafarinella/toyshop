package com.database.project.toys.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.database.project.toys.domain.Operation;

/**
 * @author nahime.torres
 * @author pia.farinella
 *
 */
@RepositoryRestResource(collectionResourceRel = "operations", path = "operations")
public interface OperationRepository extends PagingAndSortingRepository<Operation, Long> {

	Operation findById(Long id);

}
