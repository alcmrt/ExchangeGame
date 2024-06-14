package com.muratocal.exchange.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.muratocal.exchange.dtos.PortfolioDTO;
import com.muratocal.exchange.models.Portfolio;
import com.muratocal.exchange.models.Trade;

@Component
public class PortfolioMapper {

    @Autowired
    private TradeMapper tradeMapper;

    public PortfolioDTO toPortfolioDTO(Portfolio portfolio) {

        List<Trade> trades = portfolio.getTrades();

        PortfolioDTO portfolioDTO = new PortfolioDTO();
        portfolioDTO.setId(portfolio.getId());
        portfolioDTO.setUserId(portfolio.getUser().getId());
        if (trades != null) {
            portfolioDTO.setTrades(tradeMapper.toTradeDTOList(trades));
        }

        return portfolioDTO;
    }

    public List<PortfolioDTO> toPortfolioDTOList(List<Portfolio> portfolios) {
        return portfolios.stream()
                .map(this::toPortfolioDTO)
                .collect(Collectors.toList());
    }

}
