package co.com.comfenalco.springboot.models.dao;

import org.springframework.data.repository.CrudRepository;
import co.com.comfenalco.springboot.models.entity.PersonsEntity;

public interface IPersonsDao extends CrudRepository<PersonsEntity, Long>{

//	public PersonsEntity findByDocument(String documentNumber);
}
