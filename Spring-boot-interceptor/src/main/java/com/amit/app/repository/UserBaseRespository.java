package com.amit.app.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

/**
*
* @author Amit Patil
*
**/
@NoRepositoryBean
public interface UserBaseRespository<T, ID extends Serializable> extends Repository<T, ID> {

	@Query(value = "SELECT u FROM User u where u.id = :userId")
	public T getEntityById(@Param("userId") String userId);
	
	public T save(T object);
}
