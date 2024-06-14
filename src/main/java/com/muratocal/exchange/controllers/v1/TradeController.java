package com.muratocal.exchange.controllers.v1;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muratocal.exchange.dtos.TradeBuyDTO;
import com.muratocal.exchange.dtos.TradeDTO;
import com.muratocal.exchange.dtos.TradeSellDTO;
import com.muratocal.exchange.mappers.TradeMapper;
import com.muratocal.exchange.models.Trade;
import com.muratocal.exchange.services.TradeService;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/v1/trades")
@Tag(name = "Trades", description = "Trade operations")
public class TradeController {

    @Autowired
    private TradeService tradeService;

    @Autowired
    private TradeMapper tradeMapper;

    @PostMapping("/buy")
    public ResponseEntity<?> buyShare(@RequestBody TradeBuyDTO trade) {

        String shareSymbol = trade.getShareSymbol();
        Long portfolioId = trade.getPortfolioId();
        int quantity = trade.getQuantity();
        BigDecimal price = trade.getPrice();

        try {
            Trade createdTrade = tradeService.buyShare(portfolioId, shareSymbol, quantity, price);
            return ResponseEntity.ok(tradeMapper.toTradeDTO(createdTrade));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/sell")
    public ResponseEntity<?> sellShare(@RequestBody TradeSellDTO trade) {

        String symbol = trade.getShareSymbol();
        Long portfolioId = trade.getPortfolioId();
        int quantity = trade.getQuantity();
        // BigDecimal price = trade.getPrice();

        try {
            Trade createdTrade = tradeService.sellShare(portfolioId, symbol, quantity);
            return ResponseEntity.ok(tradeMapper.toTradeDTO(createdTrade));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTradeById(@PathVariable Long id) {

        try {
            Trade trade = tradeService.getTradeById(id);
            return ResponseEntity.ok(tradeMapper.toTradeDTO(trade)); // return TradeDTO object
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<TradeDTO>> getUsers() {
        List<Trade> trades = tradeService.getTrades();
        return ResponseEntity.ok(tradeMapper.toTradeDTOList(trades));
    }
}
