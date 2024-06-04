package com.muratocal.exchange.controllers.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muratocal.exchange.models.Share;
import com.muratocal.exchange.services.ShareService;

@RestController
@RequestMapping("/api/v1/shares")
public class ShareController {
    
    @Autowired
    private ShareService shareService;

    @PostMapping
    public ResponseEntity<Share> createShare(@RequestBody Share share) {
        Share createdShare = shareService.saveShare(share);
        return ResponseEntity.ok(createdShare);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Share> getShareById(@PathVariable Long id) {
        Share share = shareService.getShareById(id);
        return ResponseEntity.ok(share);
    }

    @GetMapping("/symbol/{symbol}")
    public ResponseEntity<Share> getShareBySymbol(@PathVariable String symbol) {
        Share share = shareService.getShareBySymbol(symbol);
        return ResponseEntity.ok(share);
    }
}