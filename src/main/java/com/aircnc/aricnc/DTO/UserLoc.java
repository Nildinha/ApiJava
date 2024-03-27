package com.aircnc.aricnc.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserLoc {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLoc;
	private String email;
	
	public Long getIdLoc() {
		return idLoc;
	}
	public void setIdLoc(Long idLoc) {
		this.idLoc = idLoc;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
