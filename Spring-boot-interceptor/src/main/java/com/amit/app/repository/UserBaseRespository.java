package com.amit.app.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

@NoRepositoryBean
public interface UserBaseRespository<T, ID extends Serializable> extends Repository<T, ID> {

	@Query(value = "SELECT * FROM USER u where u.id = :userId", nativeQuery = true)
	public T getEntityById(@Param("userId") String userId);
	
	public T save(T object);
}
