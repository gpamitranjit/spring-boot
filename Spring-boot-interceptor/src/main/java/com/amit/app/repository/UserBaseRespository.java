package com.amit.app.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

@NoRepositoryBean
public interface UserBaseRespository<T, ID extends Serializable> extends Repository<T, ID> {

	@Query(value = "SELECT u FROM USER u where u.id = :userId")
	public T getEntityById(@Param("id") String userId);
}
