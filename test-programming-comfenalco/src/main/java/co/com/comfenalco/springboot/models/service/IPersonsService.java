package co.com.comfenalco.springboot.models.service;

import java.util.List;
import co.com.comfenalco.springboot.models.entity.PersonsEntity;

public interface IPersonsService {

	public List<PersonsEntity> findAll();

	public PersonsEntity findById(Long id);
	
	public PersonsEntity save(PersonsEntity person);
	
	public void delete(Long id);
	
	public PersonsEntity findByDocument(String documentNumber);
	
	public List<String> findTypeDocument();
	
	public PersonsEntity personAssign();

}
