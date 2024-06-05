package com.muratocal.exchange.services;

import com.muratocal.exchange.models.Trade;

public interface TradeService {

    Trade buyShare(Long portfolioId, String symbol, Integer quantity);

    Trade sellShare(Long portfolioId, String symbol, Integer quantity);

    Trade getTradeById(Long id);
}
