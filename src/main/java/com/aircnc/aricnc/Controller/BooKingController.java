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

import com.aircnc.aricnc.DTO.Booking;
import com.aircnc.aricnc.Services.BookingService;



@RestController
@RequestMapping("/Booking")
public class BooKingController {
	
	@Autowired
	private BookingService bookingService;

	private BooKingController(BookingService bookingService) {
		this.bookingService = bookingService;
		
	}
	@GetMapping("/all")
	public ResponseEntity<List<Booking>> getAllBooking(){
		List<Booking> booking = bookingService.getAllBooking();
		return new ResponseEntity<>(booking, HttpStatus.OK);
	}
	@PostMapping("/send")
	public ResponseEntity<Booking> creatBooking(
			@RequestBody Booking booking){
		Booking createdBooking = bookingService.createBooking(booking);
		return new ResponseEntity<>(createdBooking, HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void>deleteBooking(@PathVariable Long id){
		Optional<Booking> existBooking = bookingService.getBooking(id);
		if(existBooking.isPresent()) {
			bookingService.deleteBooking(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		
		
	}
	
}


