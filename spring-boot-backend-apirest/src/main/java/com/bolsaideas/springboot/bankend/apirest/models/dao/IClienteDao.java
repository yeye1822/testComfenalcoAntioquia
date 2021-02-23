package com.bolsaideas.springboot.bankend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;
import com.bolsaideas.springboot.bankend.apirest.models.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long>{
	
	public Cliente findByDocumento(String documento);

}
