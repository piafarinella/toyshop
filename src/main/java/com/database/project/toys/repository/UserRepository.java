package com.database.project.toys.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.database.project.toys.domain.User;
import com.google.common.base.Optional;

/**
 * @author nahime.torres
 * @author pia.farinella
 *
 */
@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	User findById(Long id);

	Optional<User> findByUserName(String userName);

}
