package com.muratocal.exchange.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.muratocal.exchange.models.Share;

@Repository
public interface ShareRepository extends JpaRepository<Share, Long> {
    Share findSymbol(String symbol);
}
