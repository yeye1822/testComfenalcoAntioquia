package co.com.comfenalco.springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.com.comfenalco.springboot.models.entity.InventoryPrizeEntity;
import co.com.comfenalco.springboot.models.entity.PersonsEntity;
import co.com.comfenalco.springboot.models.service.IInventoryPrizeService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class InventoryPrizeControllers {

	@Autowired
	IInventoryPrizeService inventoryPrizeService;
	
	@GetMapping("/prize")
	public List<InventoryPrizeEntity> findAll(){
		return inventoryPrizeService.findAll();
	}
	
	@GetMapping("/prize/{id}")
	public InventoryPrizeEntity showId(@PathVariable long id) {
		return inventoryPrizeService.findById(id);
	}
	
	@PostMapping("/prize")
	@ResponseStatus(HttpStatus.CREATED)
	public InventoryPrizeEntity createPrize(@RequestBody InventoryPrizeEntity prize) {
		return inventoryPrizeService.save(prize);
	}
	
	@PutMapping("/prize/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public InventoryPrizeEntity updatePrize(@RequestBody InventoryPrizeEntity prize, @PathVariable long id) {
		InventoryPrizeEntity prizeCurrent = inventoryPrizeService.findById(id);
		prizeCurrent.setDescription(prize.getDescription());
		prizeCurrent.setAmount(prize.getAmount());
		
		return inventoryPrizeService.save(prizeCurrent);
	}
	
	@DeleteMapping("/prize/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePrize(@PathVariable long id) {
		inventoryPrizeService.delete(id);
	}
	
	@GetMapping("/showPrize")
	public InventoryPrizeEntity showPrize() {
		return inventoryPrizeService.prizeAssign();
	}
			
}
