package com.aircnc.aricnc.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aircnc.aricnc.DTO.UserLoc;
import com.aircnc.aricnc.Interfaces.UserLocInterface;

@Service
public class LocService {
	
	@Autowired
	private UserLocInterface locInterface;
	
	public LocService(UserLocInterface locRepo) {
		this.locInterface = locRepo;
	}
	// crud = c create
	public UserLoc createUserLoc(UserLoc loc) {
		return locInterface.save(loc);
		
	}
	
	public void deleteUserLoc(Long id) {
		locInterface.deleteById(id);
	}
	
	public void updteUserLoc(Long id, UserLoc loc) {
		loc.setIdLoc(id);
		locInterface.save(loc);
	}
	
	public List<UserLoc> getAllUserLoc(){
		return locInterface.findAll();
	}
	public Optional<UserLoc> getUserLocById(Long id){
		return locInterface.findById(id);
	}

}
