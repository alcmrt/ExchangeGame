package com.muratocal.exchange.services;

import java.math.BigDecimal;
import java.util.List;

import com.muratocal.exchange.models.Trade;

public interface TradeService {

    Trade buyShare(Long portfolioId, String shareSymbol, Integer quantity, BigDecimal price);

    // Trade buyShare(Long portfolioId, Long shareId, Integer quantity);

    Trade sellShare(Long portfolioId, String symbol, Integer quantity);

    Trade getTradeById(Long id);

    List<Trade> getTrades();
}
