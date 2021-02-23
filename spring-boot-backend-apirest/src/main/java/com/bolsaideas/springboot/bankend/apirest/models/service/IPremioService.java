package com.bolsaideas.springboot.bankend.apirest.models.service;

import java.util.List;
import com.bolsaideas.springboot.bankend.apirest.models.entity.Premio;

public interface IPremioService {
	
	public List<Premio> findAll();

	public Premio findById(Long id);
	
	public Premio save(Premio premio);
	
	public void delete(Long id);
	
	public Premio premioAsignar();

}
