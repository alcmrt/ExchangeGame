package com.muratocal.exchange.dtos;

public class UserDTO {
    private Long id;
    private String name;

    private PortfolioDTO portfolioDTO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PortfolioDTO getPortfolioDTO() {
        return portfolioDTO;
    }

    public void setPortfolioDTO(PortfolioDTO portfolioDTO) {
        this.portfolioDTO = portfolioDTO;
    }
}
