package com.muratocal.exchange.controllers.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muratocal.exchange.models.Trade;
import com.muratocal.exchange.services.TradeService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/v1/trades")
public class TradeController {

    @Autowired
    private TradeService tradeService;

    /*
     * @PostMapping("/buy/portfolio/{portfolioId}/share/{symbol}/trade/{quantity}")
     * public ResponseEntity<Trade> buyShare(
     * 
     * @PathVariable("portfolioId") Long portfolio_id,
     * 
     * @PathVariable("symbol") String symbol,
     * 
     * @PathVariable("quantity") int quantity) {
     * 
     * Trade createdTrade = tradeService.buyShare(portfolio_id, symbol, quantity);
     * return ResponseEntity.ok(createdTrade);
     * }
     */

    @PostMapping("/buy")
    public ResponseEntity<Trade> buyShare(@RequestBody Trade trade) {

        String symbol = trade.getShare().getSymbol();
        Long portfolioId = trade.getPortfolio().getId();
        int quantity = trade.getQuantity();

        Trade createdTrade = tradeService.buyShare(portfolioId, symbol, quantity);
        return ResponseEntity.ok(createdTrade);
    }

    @PostMapping("/sell")
    public ResponseEntity<Trade> sellShare(@RequestBody Trade trade) {

        String symbol = trade.getShare().getSymbol();
        Long portfolioId = trade.getPortfolio().getId();
        int quantity = trade.getQuantity();

        Trade createdTrade = tradeService.sellShare(portfolioId, symbol, quantity);
        return ResponseEntity.ok(createdTrade);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trade> getTradeById(@PathVariable Long id) {
        Trade trade = tradeService.getTradeById(id);
        return ResponseEntity.ok(trade);
    }

}
