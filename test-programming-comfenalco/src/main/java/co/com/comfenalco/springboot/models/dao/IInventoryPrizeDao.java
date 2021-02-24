package co.com.comfenalco.springboot.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import co.com.comfenalco.springboot.models.entity.InventoryPrizeEntity;

public interface IInventoryPrizeDao extends CrudRepository<InventoryPrizeEntity, Long>{
	@Query(value = "SELECT * FROM tbl_inventory_prize WHERE amount > 0  ORDER BY RAND() LIMIT 1", nativeQuery = true)
	public InventoryPrizeEntity prizeAssign();
}
