package com.muratocal.exchange.services;

public interface TradeService {

    String buyShare(Long portfolioId, String symbol, Integer quantity);

    String sllShare(Long portfolioId, String symbol, Integer quantity);
}
