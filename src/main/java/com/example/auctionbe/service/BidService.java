package com.example.auctionbe.service;

import com.example.auctionbe.entity.AuctionItem;
import com.example.auctionbe.entity.Bid;

import java.util.List;

public interface BidService {
    Bid getBid(Long id);
    List<Bid> getBids();
    Bid save(Bid bid);
}
