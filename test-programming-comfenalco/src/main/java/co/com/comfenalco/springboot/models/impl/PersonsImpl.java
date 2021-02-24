package co.com.comfenalco.springboot.models.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.comfenalco.springboot.models.dao.IPersonsDao;
import co.com.comfenalco.springboot.models.entity.PersonsEntity;
import co.com.comfenalco.springboot.models.service.IPersonsService;

@Service
public class PersonsImpl implements IPersonsService{
	
	@Autowired
	private IPersonsDao personsDao;

	@Override
	@Transactional(readOnly = true)
	public List<PersonsEntity> findAll() {
		return (List<PersonsEntity>) personsDao.findAll()
;	}

	@Override
	@Transactional(readOnly = true)
	public PersonsEntity findById(Long id) {
		return personsDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public PersonsEntity save(PersonsEntity person) {
		return personsDao.save(person);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		personsDao.deleteById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public PersonsEntity findByDocument(String documentNumber) {
		return personsDao.findByDocument(documentNumber);
	}

	@Override
	@Transactional(readOnly = true)
	public List<String> findTypeDocument(){
		return personsDao.findTypeDocument();
	}
	
	@Override
	@Transactional(readOnly = true)
	public PersonsEntity personAssign() {
		return personsDao.personAssign();
	}
}
