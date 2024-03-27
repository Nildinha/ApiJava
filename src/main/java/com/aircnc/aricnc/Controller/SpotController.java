package com.aircnc.aricnc.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aircnc.aricnc.DTO.Spot;
import com.aircnc.aricnc.Services.SpotService;

@RestController
@RequestMapping("/Spot")
public class SpotController {
	
	@Autowired
	private SpotService spotService;
	
	
	private SpotController(SpotService spotService) {
		this.spotService = spotService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Spot>> getAllSpots(){
		List<Spot> spot = spotService.getAllSpots();
		return new ResponseEntity<>(spot, HttpStatus.OK);
	}
	@GetMapping("/price")
	//requer um paramento Request
	public int countPrice(@RequestParam double valor){
		int count = spotService.countPrice(valor);
		return count;
	}
	
	
	@PostMapping("/send")
	public ResponseEntity<Spot> creatSpot(
			@RequestBody Spot spot){
		Spot createdSpot = spotService.createSpot(spot);
		return new ResponseEntity<>(createdSpot, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteSpot(@PathVariable Long id){
		Optional<Spot> existSpot = spotService.getSpotById(id);
		if(existSpot.isPresent()) {
			spotService.deleteSpot(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	
}
