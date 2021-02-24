package co.com.comfenalco.springboot.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.com.comfenalco.springboot.models.entity.AwardWinnerEntity;

public interface IAwardWinnerDao extends CrudRepository<AwardWinnerEntity, Long>{
	
	@Query(value = "SELECT * FROM tbl_award_winner WHERE id_persons = :id LIMIT 1", nativeQuery = true)
	public AwardWinnerEntity findByIdPerson(long id);
	
	@Query(value = "SELECT id, id_prize, id_persons, SUM(amount) amount, create_date FROM tbl_award_winner GROUP BY id_prize, id_persons", nativeQuery = true)
	public List<AwardWinnerEntity> searchPrize();
	
	@Query(value = "SELECT  id, id_prize, id_persons, SUM(amount) amount, create_date FROM tbl_award_winner GROUP BY id_prize;", nativeQuery = true)
	public List<AwardWinnerEntity> searchPrizeObject();
	
}
