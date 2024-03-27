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
import org.springframework.web.bind.annotation.RestController;

import com.aircnc.aricnc.DTO.UserLoc;
import com.aircnc.aricnc.Services.LocService;

@RestController
@RequestMapping("/Loc")
public class LocController {
	
	@Autowired
	private LocService locService;
	
	
	private LocController(LocService locService) {
		this.locService = locService;
	}
	@GetMapping("/all")
	public ResponseEntity<List<UserLoc>> getAllLoc(){
		List<UserLoc> loc = locService.getAllUserLoc();
		return new ResponseEntity<>(loc, HttpStatus.OK);
	}
	
	@PostMapping("/send")
	public ResponseEntity<UserLoc> creatUserLoc(
			@RequestBody UserLoc userLoc){
		UserLoc createdLoc = locService.createUserLoc(userLoc);
		return new ResponseEntity<>(createdLoc, HttpStatus.CREATED);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void>deleteUserLoc(@PathVariable Long id){
		Optional<UserLoc> existLoc = locService.getUserLocById(id);
		if(existLoc.isPresent()){
			locService.deleteUserLoc(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
