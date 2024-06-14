package com.muratocal.exchange.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.muratocal.exchange.dtos.TradeDTO;
import com.muratocal.exchange.models.Trade;

@Component
public class TradeMapper {

    public TradeDTO toTradeDTO(Trade trade) {

        TradeDTO tradeDTO = new TradeDTO();
        tradeDTO.setId(trade.getId());
        tradeDTO.setPortfolioId(trade.getPortfolio().getId());
        tradeDTO.setType(trade.getType());
        tradeDTO.setQuantity(trade.getQuantity());
        tradeDTO.setPrice(trade.getPrice());
        tradeDTO.setShareSymbol(trade.getShare() != null ? trade.getShare().getSymbol() : null);

        return tradeDTO;
    }

    public List<TradeDTO> toTradeDTOList(List<Trade> trades) {
        return trades.stream()
                .map(this::toTradeDTO)
                .collect(Collectors.toList());
    }
}
