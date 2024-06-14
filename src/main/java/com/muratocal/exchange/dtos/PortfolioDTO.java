package com.muratocal.exchange.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;
import com.muratocal.exchange.views.View;

public class PortfolioDTO {

    @JsonView(View.Retrieve.class)
    private Long id;

    @JsonView(View.Create.class)
    private Long userId;

    @JsonView(View.Retrieve.class)
    private List<TradeDTO> trades;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<TradeDTO> getTrades() {
        return trades;
    }

    public void setTrades(List<TradeDTO> trades) {
        this.trades = trades;
    }
}
