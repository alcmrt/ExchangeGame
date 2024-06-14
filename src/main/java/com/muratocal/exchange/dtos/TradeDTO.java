package com.muratocal.exchange.dtos;

import java.math.BigDecimal;

public class TradeDTO {
    private Long id;
    private Long portfolioId;
    private String type;
    private Integer quantity;
    private BigDecimal price;
    private String shareSymbol;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(Long portfolioId) {
        this.portfolioId = portfolioId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getShareSymbol() {
        return shareSymbol;
    }

    public void setShareSymbol(String shareSymbol) {
        this.shareSymbol = shareSymbol;
    }
}
