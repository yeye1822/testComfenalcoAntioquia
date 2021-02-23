package com.bolsaideas.springboot.bankend.apirest.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.bolsaideas.springboot.bankend.apirest.models.entity.Premio;

public interface IPremioDao extends CrudRepository<Premio, Long>{

	@Query(value="select * from premio where cantidad > 0 order by RAND() LIMIT 1 ", nativeQuery=true)
	public Premio premioAsignar();
}
