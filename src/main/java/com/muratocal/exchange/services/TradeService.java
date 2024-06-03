package com.muratocal.exchange.services;

public interface TradeService {

    String buyShare(Long portfolioId, String symbol, Integer quantity);

    String sellShare(Long portfolioId, String symbol, Integer quantity);
}
