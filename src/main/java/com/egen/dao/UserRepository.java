package com.egen.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.egen.entities.User;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByFirstname(@Param("firstname") String firstname);
	
	Optional<User> findByFirstnameAndLastname(@Param("firstname") String firstname, @Param("lastname") String lastname);
}
