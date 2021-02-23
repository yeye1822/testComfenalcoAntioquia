package co.com.comfenalco.springboot.controllers;

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

import co.com.comfenalco.springboot.models.entity.PersonsEntity;
import co.com.comfenalco.springboot.models.service.IPersonsService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class PersonsControllers {
	
	@Autowired
	private IPersonsService personsService;
	
	@GetMapping("/persons")
	public List<PersonsEntity> index(){
		return personsService.findAll();
	}
	
	@GetMapping("/persons/{id}")
	public PersonsEntity show(@PathVariable long id) {
		return personsService.findById(id);
	}
	
	@PostMapping("/persons")
	@ResponseStatus(HttpStatus.CREATED)
	public PersonsEntity createPerson(@RequestBody PersonsEntity person) {
		return personsService.save(person);
	}
	
	@PutMapping("/persons/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public PersonsEntity updatePerson(@RequestBody PersonsEntity person, @PathVariable long id) {
		PersonsEntity personCurrent = personsService.findById(id);
		personCurrent.setDocumentType(person.getDocumentType());
		personCurrent.setDocumentNumber(person.getDocumentNumber());
		personCurrent.setName(person.getName());
		personCurrent.setLastName(person.getLastName());
		personCurrent.setEmail(person.getEmail());
		personCurrent.setBirthDate(person.getBirthDate());
		
		return personsService.save(personCurrent);
	}
	
	@DeleteMapping("/persons/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePerson(@PathVariable long id) {
		personsService.delete(id);
	}
	
//	@GetMapping("/personByDocument/{documentNumber}")
//	public PersonsEntity showPersonByDocument(@PathVariable String documentNumber) {
//		return personsService.findByDocument(documentNumber);
//	}
}
