package com.muratocal.exchange.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muratocal.exchange.dtos.PortfolioDTO;
import com.muratocal.exchange.models.Portfolio;
import com.muratocal.exchange.models.User;
import com.muratocal.exchange.repositories.PortfolioRepository;
import com.muratocal.exchange.services.PortfolioService;
import com.muratocal.exchange.services.UserService;

@Service
public class PortfolioServiceImpl implements PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;

    @Autowired
    private UserService userService;

    @Override
    public Portfolio savePortfolio(PortfolioDTO portfolioDTO) {
        Portfolio portfolio = new Portfolio();
        User user = userService.getUserById(portfolioDTO.getUserId());
        portfolio.setUser(user);

        return portfolioRepository.save(portfolio);
    }

    @Override
    public Portfolio getPortfolioById(Long id) {
        return portfolioRepository.findById(id).orElseThrow(() -> new RuntimeException("Portfolio not found."));
    }
}
