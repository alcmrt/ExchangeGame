package com.muratocal.exchange.services;

import com.muratocal.exchange.dtos.PortfolioDTO;
import com.muratocal.exchange.models.Portfolio;

public interface PortfolioService {

    Portfolio savePortfolio(PortfolioDTO portfolioDTO);

    Portfolio getPortfolioById(Long id);
}
