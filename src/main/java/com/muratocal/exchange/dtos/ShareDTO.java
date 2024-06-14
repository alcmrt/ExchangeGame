package com.muratocal.exchange.dtos;

import java.math.BigDecimal;
import java.util.List;

public class ShareDTO {
    private Long id;
    private String symbol;
    private BigDecimal price;
    private List<TradeDTO> trades;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<TradeDTO> getTrades() {
        return trades;
    }

    public void setTrades(List<TradeDTO> trades) {
        this.trades = trades;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
