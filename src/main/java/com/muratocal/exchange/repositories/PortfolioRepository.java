package com.muratocal.exchange.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.muratocal.exchange.models.Portfolio;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {}
