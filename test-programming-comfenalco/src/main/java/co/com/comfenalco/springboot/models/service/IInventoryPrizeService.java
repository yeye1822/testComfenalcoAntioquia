package co.com.comfenalco.springboot.models.service;

import java.util.List;

import co.com.comfenalco.springboot.models.entity.InventoryPrizeEntity;

public interface IInventoryPrizeService {
	
	public List<InventoryPrizeEntity> findAll();
	
	public InventoryPrizeEntity findById(long id);
	
	public InventoryPrizeEntity save(InventoryPrizeEntity prize);
	
	public void delete(long id);
	
	public InventoryPrizeEntity prizeAssign();
		

}
