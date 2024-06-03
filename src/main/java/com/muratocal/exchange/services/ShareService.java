package com.muratocal.exchange.services;

import com.muratocal.exchange.models.Share;

public interface ShareService {

    Share savShare(Share share);

    Share getShareById(Long id);

    Share getShareBySymbol(String symbol);
}
