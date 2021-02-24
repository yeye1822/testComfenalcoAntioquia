package co.com.comfenalco.springboot.models.service;

import java.util.List;

import co.com.comfenalco.springboot.models.entity.AwardWinnerEntity;

public interface IAwardWinnerService {
	
	public List<AwardWinnerEntity> findAll();
	
	public AwardWinnerEntity findByIdPerson(long id);
	
	public AwardWinnerEntity save(AwardWinnerEntity award);
	
	public List<AwardWinnerEntity> searchPrize();
	
	public List<AwardWinnerEntity> searchPrizeObject();
	
	public void deleteAward();
		
}
