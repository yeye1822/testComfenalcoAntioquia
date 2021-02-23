package com.bolsaideas.springboot.bankend.apirest.models.service;

import java.util.List;

import com.bolsaideas.springboot.bankend.apirest.models.entity.Ganador;

public interface IGanadorService {
	
	public List<Ganador> findAll();

	public Ganador findById(Long id);
	
	public Ganador save(Ganador ganador);
	
	public void delete(Long id);
	
	public Ganador findByIdganador(String idganador);

}
