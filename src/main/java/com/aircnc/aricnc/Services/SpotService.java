package com.aircnc.aricnc.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aircnc.aricnc.DTO.Spot;
import com.aircnc.aricnc.Interfaces.SpotInterface;


@Service
public class SpotService {
	
	@Autowired
	private SpotInterface spotInterface;
	
	public SpotService(SpotInterface spotRepo) {
		this.spotInterface = spotRepo;
	}
	
	public Spot createSpot(Spot spot) {
		return spotInterface.save(spot);
	}
	
	public void deleteSpot(Long id) {
		spotInterface.deleteById(id);
	}
	
	public void updteSpot(Long id, Spot spot) {
		spot.setIdSpot(id);
		spotInterface.save(spot);
	}
	
	public List<Spot> getAllSpots(){
		return spotInterface.findAll();
	}
	 public Optional<Spot> getSpotById(Long id){
		 return spotInterface.findById(id);
	 }
	
	 // a funçao vai retorna um valor inteiro 
	 
	 public int countPrice(double valor) {
		 return spotInterface.countByPrice(valor);
	  }
}
