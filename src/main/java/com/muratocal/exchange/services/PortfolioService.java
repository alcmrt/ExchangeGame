package com.muratocal.exchange.services;

import java.util.List;

import com.muratocal.exchange.dtos.PortfolioCreateDTO;
import com.muratocal.exchange.models.Portfolio;

public interface PortfolioService {

    Portfolio savePortfolio(PortfolioCreateDTO portfolioCreateDTO);

    Portfolio getPortfolioById(Long id);

    List<Portfolio> getPortfolios();
}
