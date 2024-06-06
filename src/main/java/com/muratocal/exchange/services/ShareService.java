package com.muratocal.exchange.services;

import java.util.List;

import com.muratocal.exchange.dtos.ShareDTO;
import com.muratocal.exchange.models.Share;

public interface ShareService {

    Share saveShare(ShareDTO share);

    Share getShareById(Long id);

    Share getShareBySymbol(String symbol);

    List<Share> getShares();
}
