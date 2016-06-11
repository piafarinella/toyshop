package com.database.project.toys.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.database.project.toys.domain.Toy;

/**
 * @author nahime.torres
 * @author pia.farinella
 *
 */
@RepositoryRestResource(collectionResourceRel = "toys", path = "toys")
public interface ToyRepository extends PagingAndSortingRepository<Toy, Long> {

	Toy findById(Long id);

}
