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

import com.muratocal.exchange.dtos.ShareDTO;
import com.muratocal.exchange.models.Share;
import com.muratocal.exchange.services.ShareService;

@RestController
@RequestMapping("/api/v1/shares")
public class ShareController {

    @Autowired
    private ShareService shareService;

    @PostMapping
    public ResponseEntity<Share> createShare(@RequestBody ShareDTO share) {
        Share createdShare = shareService.saveShare(share);
        return ResponseEntity.ok(createdShare);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Share> getShareById(@PathVariable Long id) {
        Share share = shareService.getShareById(id);
        return ResponseEntity.ok(share);
    }

    @GetMapping
    public ResponseEntity<List<Share>> getShares() {
        List<Share> shares = shareService.getShares();
        return ResponseEntity.ok(shares);
    }

    @GetMapping("/symbol/{symbol}")
    public ResponseEntity<?> getShareBySymbol(@PathVariable String symbol) {

        try {
            Share share = shareService.getShareBySymbol(symbol);
            return ResponseEntity.ok(share);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
