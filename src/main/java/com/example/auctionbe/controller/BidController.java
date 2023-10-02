package com.example.auctionbe.controller;

import com.example.auctionbe.entity.Bid;
import com.example.auctionbe.service.BidService;
import com.example.auctionbe.util.LabMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BidController {
    final BidService bidService;

    @GetMapping("bids")
    public ResponseEntity<?> getBidList(){
        List<Bid> output = bidService.getBids();
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(output.size()));
        return new
                ResponseEntity<>(LabMapper.INSTANCE.getBitDTO(output), responseHeader, HttpStatus.OK);

    }

    @GetMapping("bids/{id}")
    public ResponseEntity<?> getBidById(@PathVariable("id") Long id) {
        Bid bid = bidService.getBid(id);
        if (bid != null) {
            return ResponseEntity.ok(LabMapper.INSTANCE.getBitDTO(bid));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }

}
