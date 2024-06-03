package com.muratocal.exchange.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.muratocal.exchange.models.Portfolio;
import com.muratocal.exchange.models.Share;
import com.muratocal.exchange.models.Trade;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Long> {
    List<Trade> findByPortfolioAndShare(Portfolio portfolio, Share share);
}
