package com.aircnc.aricnc.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aircnc.aricnc.DTO.Spot;

@Repository
public interface SpotInterface extends JpaRepository<Spot, Long> {
    
    // Método para obter a contagem de spots com um determinado preço
    @Query("SELECT COUNT(p) FROM Spot p WHERE p.price = :valor")
    int countByPrice(@Param("valor") double valor);
}
