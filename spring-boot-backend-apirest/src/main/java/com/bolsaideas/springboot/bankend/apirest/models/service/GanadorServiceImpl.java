package com.bolsaideas.springboot.bankend.apirest.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsaideas.springboot.bankend.apirest.models.dao.IGanadorDao;
import com.bolsaideas.springboot.bankend.apirest.models.entity.Ganador;


@Service
public class GanadorServiceImpl implements IGanadorService {
	
	@Autowired
	private IGanadorDao ganadorDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Ganador> findAll() {
		return (List<Ganador>) ganadorDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Ganador findById(Long id) {
		return ganadorDao.findById(id).orElse(null);	
	}

	@Override
	@Transactional
	public Ganador save(Ganador ganador) {
		return ganadorDao.save(ganador);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		ganadorDao.deleteById(id);
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public Ganador findByIdganador(String idganador) {
		return ganadorDao.findByIdganador(idganador);	
	}
}
