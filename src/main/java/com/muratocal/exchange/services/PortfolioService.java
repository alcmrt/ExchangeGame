package com.muratocal.exchange.services;

import com.muratocal.exchange.models.Portfolio;

public interface PortfolioService {

    Portfolio savePortfolio(Portfolio portfolio);

    Portfolio getPortfolioById(Long id);
}
