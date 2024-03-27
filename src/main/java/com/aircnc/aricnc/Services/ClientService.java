package com.aircnc.aricnc.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aircnc.aricnc.DTO.UserClient;
import com.aircnc.aricnc.Interfaces.UserClientInterfaces;

@Service
public class ClientService {
	
	@Autowired
	private UserClientInterfaces clienteService;
	
	public ClientService(UserClientInterfaces clieRepo) {
		this.clienteService = clieRepo;
	}
	
	public UserClient createUserClient(UserClient clie) {
		return clienteService.save(clie);
	}
	
	public void deleteUserClient(Long id) {
		clienteService.deleteById(id);
		
	}
	
	public void updteUserClient(Long id, UserClient clie) {
		clie.setId(id);
		clienteService.save(clie);
	}
	public List<UserClient> getAllUserClient(){
		return clienteService.findAll();
		
	}
	public Optional<UserClient> getSpotById(Long id){
		return clienteService.findById(id);
	}
	
	
	
	

	}


