package com.muratocal.exchange.config;

import com.muratocal.exchange.models.*;
import com.muratocal.exchange.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.Arrays;

@Configuration
public class DataInitialization {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository,
            PortfolioRepository portfolioRepository,
            ShareRepository shareRepository,
            TradeRepository tradeRepository) {
        return args -> {
            // Clear existing data
            tradeRepository.deleteAll();
            shareRepository.deleteAll();
            portfolioRepository.deleteAll();
            userRepository.deleteAll();

            // Create users
            User user1 = new User();
            User user2 = new User();
            User user3 = new User();
            User user4 = new User();
            User user5 = new User();

            user1.setName("Alice");
            user2.setName("Bob");
            user3.setName("Charlie");
            user4.setName("David");
            user5.setName("Eve");

            userRepository.saveAll(Arrays.asList(user1, user2, user3, user4, user5));

            // Create portfolios
            Portfolio portfolio1 = new Portfolio();
            Portfolio portfolio2 = new Portfolio();
            Portfolio portfolio3 = new Portfolio();
            Portfolio portfolio4 = new Portfolio();
            Portfolio portfolio5 = new Portfolio();

            portfolio1.setUser(user1);
            portfolio2.setUser(user2);
            portfolio3.setUser(user3);
            portfolio4.setUser(user4);
            portfolio5.setUser(user5);

            portfolioRepository.saveAll(Arrays.asList(portfolio1, portfolio2, portfolio3, portfolio4, portfolio5));

            // Create shares
            Share share1 = new Share();
            Share share2 = new Share();
            Share share3 = new Share();
            Share share4 = new Share();
            Share share5 = new Share();

            share1.setSymbol("ABC");
            share1.setPrice(new BigDecimal(100));

            share2.setSymbol("DEF");
            share2.setPrice(new BigDecimal(200));

            share3.setSymbol("GHI");
            share3.setPrice(new BigDecimal(300));

            share4.setSymbol("XYZ");
            share4.setPrice(new BigDecimal(400));

            share5.setSymbol("AFK");
            share5.setPrice(new BigDecimal(500));

            shareRepository.saveAll(Arrays.asList(share1, share2, share3, share4, share5));

            // Create trades (buy)
            Trade trade1 = new Trade();
            Trade trade2 = new Trade();
            Trade trade3 = new Trade();
            Trade trade4 = new Trade();
            Trade trade5 = new Trade();

            trade1.setType("BUY");
            trade1.setQuantity(10);
            trade1.setPrice(new BigDecimal(1000));
            trade1.setShare(share1);
            trade1.setPortfolio(portfolio1);

            trade2.setType("BUY");
            trade2.setQuantity(10);
            trade2.setPrice(new BigDecimal(2000));
            trade2.setShare(share2);
            trade2.setPortfolio(portfolio2);

            trade3.setType("BUY");
            trade3.setQuantity(10);
            trade3.setPrice(new BigDecimal(3000));
            trade3.setShare(share3);
            trade3.setPortfolio(portfolio3);

            trade4.setType("BUY");
            trade4.setQuantity(10);
            trade4.setPrice(new BigDecimal(4000));
            trade4.setShare(share4);
            trade4.setPortfolio(portfolio4);

            trade5.setType("BUY");
            trade5.setQuantity(10);
            trade5.setPrice(new BigDecimal(5000));
            trade5.setShare(share5);
            trade5.setPortfolio(portfolio5);

            tradeRepository.saveAll(Arrays.asList(trade1, trade2, trade3, trade4, trade5));

            // Create trades (sell)
            Trade trade6 = new Trade();
            Trade trade7 = new Trade();
            Trade trade8 = new Trade();
            Trade trade9 = new Trade();
            Trade trade10 = new Trade();

            trade6.setType("SELL");
            trade6.setQuantity(5);
            trade6.setPrice(new BigDecimal(500));
            trade6.setShare(share1);
            trade6.setPortfolio(portfolio1);

            trade7.setType("SELL");
            trade7.setQuantity(5);
            trade7.setPrice(new BigDecimal(1000));
            trade7.setShare(share2);
            trade7.setPortfolio(portfolio2);

            trade8.setType("SELL");
            trade8.setQuantity(5);
            trade8.setPrice(new BigDecimal(1500));
            trade8.setShare(share3);
            trade8.setPortfolio(portfolio3);

            trade9.setType("SELL");
            trade9.setQuantity(5);
            trade9.setPrice(new BigDecimal(2000));
            trade9.setShare(share4);
            trade9.setPortfolio(portfolio4);

            trade10.setType("SELL");
            trade10.setQuantity(5);
            trade10.setPrice(new BigDecimal(2500));
            trade10.setShare(share5);
            trade10.setPortfolio(portfolio5);

            tradeRepository.saveAll(Arrays.asList(trade6, trade7, trade8, trade9, trade10));
        };
    }
}