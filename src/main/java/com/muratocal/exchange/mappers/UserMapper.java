package com.muratocal.exchange.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.muratocal.exchange.dtos.UserDTO;
import com.muratocal.exchange.models.Portfolio;
import com.muratocal.exchange.models.User;

@Component
public class UserMapper {

    @Autowired
    private PortfolioMapper portfolioMapper;

    public UserDTO toUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());

        Portfolio portfolio = user.getPortfolio();

        if (portfolio != null) {
            userDTO.setPortfolioDTO(portfolioMapper.toPortfolioDTO(portfolio));
        }

        return userDTO;
    }

    public List<UserDTO> toUserDTOList(List<User> users) {
        return users.stream()
                .map(this::toUserDTO)
                .collect(Collectors.toList());
    }
}
