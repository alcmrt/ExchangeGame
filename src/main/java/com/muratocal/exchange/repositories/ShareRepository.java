package com.muratocal.exchange.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.muratocal.exchange.models.Share;

@Repository
public interface ShareRepository extends JpaRepository<Share, Long> {
    
    @Query("select s from Share s where s.symbol = ?1")
    Share findBySymbol(String symbol);
}
