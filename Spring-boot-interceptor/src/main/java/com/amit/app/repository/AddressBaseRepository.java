package com.amit.app.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

@NoRepositoryBean
public interface AddressBaseRepository<T, ID extends Serializable> extends Repository<T, ID> {

	@Query(value = "SELECT a FROM Address a where a.id = :addressId")
	public T getEntityById(@Param("addressId") ID id);
	
	public T save(T object);
}
