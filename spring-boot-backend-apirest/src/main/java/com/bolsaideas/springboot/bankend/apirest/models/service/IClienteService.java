package com.bolsaideas.springboot.bankend.apirest.models.service;

import java.util.List;

import com.bolsaideas.springboot.bankend.apirest.models.entity.Cliente;
import com.bolsaideas.springboot.bankend.apirest.models.entity.Ganador;

public interface IClienteService {
	
	public List<Cliente> findAll();

	public Cliente findById(Long id);
	
	public Cliente save(Cliente cliente);
	
	public void delete(Long id);
	
	public Cliente findByDocumento(String documento);


}
