package com.aircnc.aricnc.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aircnc.aricnc.DTO.Booking;

public interface BookingInterface extends JpaRepository<Booking, Long>{

}
