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

import com.bolsaideas.springboot.bankend.apirest.models.entity.Ganador;
import com.bolsaideas.springboot.bankend.apirest.models.service.IGanadorService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class GanadorRestController {
	
	@Autowired
	private IGanadorService ganadorService;
	
	@GetMapping("/ganadores")
	public List<Ganador> index(){
		return ganadorService.findAll();
	}
	
	@GetMapping("/ganadores/{id}")
	public Ganador show(@PathVariable long id) {
		return ganadorService.findById(id);
	}
	
	@PostMapping("/ganadores")
	@ResponseStatus(HttpStatus.CREATED)
	public Ganador create(@RequestBody Ganador ganador) {
		return ganadorService.save(ganador);
	}
	
	@PutMapping("/ganadores/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Ganador update(@RequestBody Ganador ganador, @PathVariable long id) {
		Ganador ganadorActual = ganadorService.findById(id);
		ganadorActual.setIdganador(ganador.getIdganador());
		ganadorActual.setIdpremio(ganador.getIdpremio());
		ganadorActual.setTipo(ganador.getTipo());
		ganadorActual.setDocumento(ganador.getDocumento());
		ganadorActual.setApellido(ganador.getApellido());
		ganadorActual.setNombre(ganador.getNombre());
		ganadorActual.setEmail(ganador.getEmail());
		return ganadorService.save(ganadorActual);
	}
	
	@DeleteMapping("/ganadores/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable long id) {
		ganadorService.delete(id);
	}
	
	@GetMapping("/ganadoresbyid/{idganador}")
	public Ganador show(@PathVariable String idganador) {
		return ganadorService.findByIdganador(idganador);
	}
}
