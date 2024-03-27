package com.aircnc.aricnc.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aircnc.aricnc.DTO.Booking;
import com.aircnc.aricnc.Interfaces.BookingInterface;


@Service
public class BookingService {
	
	@Autowired
	private BookingInterface bookingInterface;
	//esse bloco interligar com a Interface
	
	public BookingService(BookingInterface bookRepo) {
		this.bookingInterface = bookRepo;
	}
	
	public Booking createBooking(Booking book) {
		return bookingInterface.save(book);
	}
	
	public void deleteBooking(Long id) {
		bookingInterface.deleteById(id);
	}
	
	public void updteBooking(Long id, Booking book) {
		book.setIdSpot(id);
		bookingInterface.save(book);
	}
	
	public List<Booking> getAllBooking(){
		return bookingInterface.findAll();
	}
	
	public Optional<Booking> getBooking(Long id){
		return bookingInterface.findById(id);
	}
	
}
	
	


