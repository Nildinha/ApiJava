package com.aircnc.aricnc.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aircnc.aricnc.DTO.UserLoc;

public interface UserLocInterface extends JpaRepository<UserLoc, Long> {

}
