package com.muratocal.exchange.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.muratocal.exchange.dtos.ShareDTO;
import com.muratocal.exchange.models.Share;
import com.muratocal.exchange.models.Trade;

@Component
public class ShareMapper {

    @Autowired
    private TradeMapper tradeMapper;

    public ShareDTO toShareDTO(Share share) {
        List<Trade> trades = share.getTrades();

        ShareDTO shareDTO = new ShareDTO();
        shareDTO.setId(share.getId());
        shareDTO.setSymbol(share.getSymbol());
        shareDTO.setPrice(share.getPrice());
        if (trades != null) {
            shareDTO.setTrades(tradeMapper.toTradeDTOList(trades));
        }

        return shareDTO;
    }

    public List<ShareDTO> toShareDTOList(List<Share> shares) {
        return shares.stream()
                .map(this::toShareDTO)
                .collect(Collectors.toList());
    }
}
