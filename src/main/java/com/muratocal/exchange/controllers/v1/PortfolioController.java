package com.muratocal.exchange.controllers.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muratocal.exchange.dtos.PortfolioCreateDTO;
import com.muratocal.exchange.dtos.PortfolioDTO;
import com.muratocal.exchange.mappers.PortfolioMapper;
import com.muratocal.exchange.models.Portfolio;
import com.muratocal.exchange.services.PortfolioService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/v1/portfolios")
@Tag(name = "Portfolios", description = "Portfolio operations")
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    @Autowired
    private PortfolioMapper portfolioMapper;

    @PostMapping
    public ResponseEntity<?> createPortfolio(@RequestBody PortfolioCreateDTO portfolioCreateDTO) {

        try {

            Portfolio createdPortfolio = portfolioService.savePortfolio(portfolioCreateDTO);
            return ResponseEntity.ok(portfolioMapper.toPortfolioDTO(createdPortfolio));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPortfolioById(@PathVariable Long id) {

        try {
            Portfolio portfolio = portfolioService.getPortfolioById(id);
            return ResponseEntity.ok(portfolioMapper.toPortfolioDTO(portfolio));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<PortfolioDTO>> getPortfolios() {
        List<Portfolio> portfolios = portfolioService.getPortfolios();
        return ResponseEntity.ok(portfolioMapper.toPortfolioDTOList(portfolios));
    }
}
