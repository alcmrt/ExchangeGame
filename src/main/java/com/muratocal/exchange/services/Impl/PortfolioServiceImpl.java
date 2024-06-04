package com.muratocal.exchange.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.muratocal.exchange.models.Portfolio;
import com.muratocal.exchange.repositories.PortfolioRepository;
import com.muratocal.exchange.services.PortfolioService;

public class PortfolioServiceImpl implements PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;

    @Override
    public Portfolio savePortfolio(Portfolio portfolio) {
        return portfolioRepository.save(portfolio);
    }

    @Override
    public Portfolio getPortfolioById(Long id) {
        return portfolioRepository.findById(id).orElseThrow(() -> new RuntimeException("Portfolio not found."));
    }
}
