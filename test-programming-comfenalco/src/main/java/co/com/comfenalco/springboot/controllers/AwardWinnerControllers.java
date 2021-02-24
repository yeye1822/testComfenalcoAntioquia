package co.com.comfenalco.springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.com.comfenalco.springboot.models.entity.AwardWinnerEntity;
import co.com.comfenalco.springboot.models.service.IAwardWinnerService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class AwardWinnerControllers {

	@Autowired
	IAwardWinnerService awardWinnerService;
	
	@GetMapping("/award")
	public List<AwardWinnerEntity> findAll(){
		return awardWinnerService.findAll();
	}
	
	@GetMapping("/award/{id}")
	public AwardWinnerEntity showId(@PathVariable long id) {
		return awardWinnerService.findByIdPerson(id);
	}
	
	@PostMapping("/award")
	@ResponseStatus(HttpStatus.CREATED)
	public AwardWinnerEntity createAward(@RequestBody AwardWinnerEntity award){
		return awardWinnerService.save(award);
	}
	
	@GetMapping("/awardWinner")
	public List<AwardWinnerEntity> searchPrize() {
		return awardWinnerService.searchPrize();
	}
	
	@GetMapping("/awardPrize")
	public List<AwardWinnerEntity> searchPrizeObject() {
		return awardWinnerService.searchPrizeObject();
	}
	
	@DeleteMapping("/awardDeleteAll")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteAward() {
		awardWinnerService.deleteAward();
	}
}
