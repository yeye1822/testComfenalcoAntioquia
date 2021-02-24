package co.com.comfenalco.springboot.models.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.comfenalco.springboot.models.dao.IInventoryPrizeDao;
import co.com.comfenalco.springboot.models.entity.InventoryPrizeEntity;
import co.com.comfenalco.springboot.models.service.IInventoryPrizeService;

@Service
public class InventoryPrizeImpl  implements IInventoryPrizeService{
	
	@Autowired
	IInventoryPrizeDao inventoryPrizeDao;

	@Override
	@Transactional(readOnly = true)
	public List<InventoryPrizeEntity> findAll() {
		// TODO Auto-generated method stub
		return (List<InventoryPrizeEntity>) inventoryPrizeDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public InventoryPrizeEntity findById(long id) {
		// TODO Auto-generated method stub
		return inventoryPrizeDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public InventoryPrizeEntity save(InventoryPrizeEntity prize) {
		// TODO Auto-generated method stub
		return inventoryPrizeDao.save(prize);
	}

	@Override
	@Transactional
	public void delete(long id) {
		// TODO Auto-generated method stub
		inventoryPrizeDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public InventoryPrizeEntity prizeAssign() {
		// TODO Auto-generated method stub
		return (InventoryPrizeEntity) inventoryPrizeDao.prizeAssign();
	}

}
