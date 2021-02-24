package co.com.comfenalco.springboot.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.com.comfenalco.springboot.models.entity.InventoryPrizeEntity;
import co.com.comfenalco.springboot.models.entity.PersonsEntity;

public interface IPersonsDao extends CrudRepository<PersonsEntity, Long>{
	@Query(value = "SELECT * FROM tbl_persons WHERE document_number = :documentNumber", nativeQuery = true)
	public PersonsEntity findByDocument(String documentNumber);
	
	@Query(value = "SELECT DISTINCT(document_type) FROM tbl_persons", nativeQuery = true)
	public List<String> findTypeDocument();
	
	@Query(value = "SELECT * FROM tbl_persons ORDER BY RAND() LIMIT 1", nativeQuery = true)
	public PersonsEntity personAssign();
}
