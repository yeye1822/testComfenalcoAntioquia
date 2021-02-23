package com.bolsaideas.springboot.bankend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bolsaideas.springboot.bankend.apirest.models.entity.Cliente;
import com.bolsaideas.springboot.bankend.apirest.models.entity.Ganador;
import com.bolsaideas.springboot.bankend.apirest.models.entity.Premio;
import com.bolsaideas.springboot.bankend.apirest.models.service.IClienteService;
import com.bolsaideas.springboot.bankend.apirest.models.service.IPremioService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class PremioRestController {
	
	@Autowired
	private IPremioService premioService;
	
	@GetMapping("/premios")
	public List<Premio> index(){
		return premioService.findAll();
	}
	
	@GetMapping("/premios/{id}")
	public Premio show(@PathVariable long id) {
		return premioService.findById(id);
	}
	
	@PostMapping("/premios")
	@ResponseStatus(HttpStatus.CREATED)
	public Premio create(@RequestBody Premio premio) {
		return premioService.save(premio);
	}
	
	@PutMapping("/premios/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Premio update(@RequestBody Premio premio, @PathVariable long id) {
		Premio premioActual = premioService.findById(id);
		premioActual.setDescripcion(premio.getDescripcion());
		premioActual.setCantidad(premio.getCantidad());
		return premioService.save(premioActual);
	}
	
	@DeleteMapping("/premios/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable long id) {
		premioService.delete(id);
	}
	
	@GetMapping("/premioAsignar")
	public Premio showPremio(){
		return premioService.premioAsignar();
	}
	
}
