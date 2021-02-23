package com.bolsaideas.springboot.bankend.apirest.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsaideas.springboot.bankend.apirest.models.dao.IClienteDao;
import com.bolsaideas.springboot.bankend.apirest.models.dao.IGanadorDao;
import com.bolsaideas.springboot.bankend.apirest.models.entity.Cliente;
import com.bolsaideas.springboot.bankend.apirest.models.entity.Ganador;


@Service
public class ClienteServiceImpl implements IClienteService {
	
	@Autowired
	private IClienteDao clienteDao;
	
	@Autowired
	private IGanadorDao repositoryGanadorDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long id) {
		return clienteDao.findById(id).orElse(null);	
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		return clienteDao.save(cliente);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clienteDao.deleteById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Cliente findByDocumento(String documento) {
		return clienteDao.findByDocumento(documento);	
	}
	
}
