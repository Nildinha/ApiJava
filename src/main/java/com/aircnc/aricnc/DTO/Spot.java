package com.aircnc.aricnc.DTO;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Spot {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdSpot;
	private String thumbnail;
	private String company;
	private double price;
	private String techs;
	
	public Long getIdSpot() {
		return IdSpot;
	}
	public void setIdSpot(Long idSpot) {
		IdSpot = idSpot;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getTechs() {
		return techs;
	}
	public void setTechs(String techs) {
		this.techs = techs;
	}
}