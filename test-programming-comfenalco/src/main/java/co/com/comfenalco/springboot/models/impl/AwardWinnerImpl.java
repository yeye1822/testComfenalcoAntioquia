package co.com.comfenalco.springboot.models.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.comfenalco.springboot.models.dao.IAwardWinnerDao;
import co.com.comfenalco.springboot.models.entity.AwardWinnerEntity;
import co.com.comfenalco.springboot.models.service.IAwardWinnerService;

@Service
public class AwardWinnerImpl implements IAwardWinnerService {

	@Autowired
	IAwardWinnerDao awardWinnerDao;

	@Override
	@Transactional(readOnly = true)
	public List<AwardWinnerEntity> findAll() {
		// TODO Auto-generated method stub
		return (List<AwardWinnerEntity>) awardWinnerDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public AwardWinnerEntity findByIdPerson(long id) {
		// TODO Auto-generated method stub
		return awardWinnerDao.findByIdPerson(id);
	}

	@Override
	@Transactional
	public AwardWinnerEntity save(AwardWinnerEntity award) {
		// TODO Auto-generated method stub
		return awardWinnerDao.save(award);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<AwardWinnerEntity> searchPrize() {
		return (List<AwardWinnerEntity>) awardWinnerDao.searchPrize();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<AwardWinnerEntity> searchPrizeObject() {
		return (List<AwardWinnerEntity>) awardWinnerDao.searchPrizeObject();
	}
	
	@Override
	@Transactional
	public void deleteAward() {
		awardWinnerDao.deleteAll();
	}
	
	
}
