package com.muratocal.exchange.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.muratocal.exchange.models.Portfolio;
import com.muratocal.exchange.models.Share;
import com.muratocal.exchange.models.Trade;
import com.muratocal.exchange.repositories.PortfolioRepository;
import com.muratocal.exchange.repositories.ShareRepository;
import com.muratocal.exchange.repositories.TradeRepository;
import com.muratocal.exchange.services.TradeService;

import jakarta.transaction.Transactional;

public class TradeServiceImpl implements TradeService {

    @Autowired
    private TradeRepository tradeRepository;

    @Autowired
    private PortfolioRepository portfolioRepository;

    @Autowired
    private ShareRepository shareRepository;

    @Override
    @Transactional
    public Trade buyShare(Long portfolioId, String symbol, Integer quantity) {

        Portfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new RuntimeException("Portfolio not found"));

        Share share = shareRepository.findSymbol(symbol);

        if (share == null) {
            throw new RuntimeException("Share not found");
        }

        Trade trade = new Trade();
        trade.setType("BUY");
        trade.setQuantity(quantity);
        trade.setPortfolio(portfolio);
        trade.setShare(share);

        return tradeRepository.save(trade);

        // return "Buy trade executed successfully";
    }

    @Override
    @Transactional
    public Trade sellShare(Long portfolioId, String symbol, Integer quantity) {

        Portfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new RuntimeException("Portfolio not found"));

        Share share = shareRepository.findSymbol(symbol);
        if (share == null) {
            throw new RuntimeException("Share not found");
        }

        List<Trade> trades = tradeRepository.findByPortfolioAndShare(portfolio, share);

        int totalBought = trades.stream().filter(t -> t.getType().equals("BUY")).mapToInt(Trade::getQuantity).sum();
        int totalSold = trades.stream().filter(t -> t.getType().equals("SELL")).mapToInt(Trade::getQuantity).sum();

        if (totalBought - totalSold < quantity) {
            throw new RuntimeException("Insufficient shares to sell");
        }

        Trade trade = new Trade();

        trade.setType("SELL");
        trade.setQuantity(quantity);
        trade.setPrice(share.getPrice());
        trade.setPortfolio(portfolio);
        trade.setShare(share);

        return tradeRepository.save(trade);

        // return "Sell trade executed successfully";
    }

    @Override
    public Trade getTradeById(Long id) {
        return tradeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trade not found"));
    }

}
