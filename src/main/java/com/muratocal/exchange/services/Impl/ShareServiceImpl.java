package com.muratocal.exchange.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muratocal.exchange.dtos.ShareDTO;
import com.muratocal.exchange.models.Share;
import com.muratocal.exchange.repositories.ShareRepository;
import com.muratocal.exchange.services.ShareService;

@Service
public class ShareServiceImpl implements ShareService {

    @Autowired
    private ShareRepository shareRepository;

    @Override
    public Share saveShare(ShareDTO shareDTO) {
        Share share = new Share();
        share.setSymbol(shareDTO.getSymbol());
        share.setPrice(shareDTO.getPrice());

        return shareRepository.save(share);
    }

    @Override
    public Share getShareById(Long id) {
        return shareRepository.findById(id).orElseThrow(() -> new RuntimeException("Share not found."));
    }

    @Override
    public List<Share> getShares() {
        return shareRepository.findAll();
    }

    @Override
    public Share getShareBySymbol(String symbol) {
        return null;
        // return shareRepository.findSymbol(symbol);
    }
}
