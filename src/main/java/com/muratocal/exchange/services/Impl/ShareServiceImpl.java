package com.muratocal.exchange.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.muratocal.exchange.models.Share;
import com.muratocal.exchange.repositories.ShareRepository;
import com.muratocal.exchange.services.ShareService;

public class ShareServiceImpl implements ShareService {

    @Autowired
    private ShareRepository shareRepository;

    @Override
    public Share saveShare(Share share) {
        return shareRepository.save(share);
    }

    @Override
    public Share getShareById(Long id) {
        return shareRepository.findById(id).orElseThrow(() -> new RuntimeException("Share not found."));
    }

    @Override
    public Share getShareBySymbol(String symbol) {
        return shareRepository.findSymbol(symbol);
    }
}
