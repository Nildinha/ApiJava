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

import com.aircnc.aricnc.DTO.UserClient;
import com.aircnc.aricnc.Services.ClientService;

@RestController
@RequestMapping(value="/Client")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	private ClientController(ClientService clientService) {
		this.clientService = clientService;
	}
	@GetMapping("/all")
	public ResponseEntity<List<UserClient>> getAllUserClient(){
		List<UserClient> client = clientService.getAllUserClient();
		return new ResponseEntity<>(client, HttpStatus.OK);
	}
	
	@PostMapping("/send")
	public ResponseEntity<UserClient> creatUserClient(
		@RequestBody UserClient userclient){
		UserClient createdClient = clientService.createUserClient(userclient);
		return new ResponseEntity<>(createdClient, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void>deleteUserClient(@PathVariable Long id){
		Optional<UserClient> existClient = clientService.getSpotById(id);
		if(existClient.isPresent()){
			clientService.deleteUserClient(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
			
	
}
