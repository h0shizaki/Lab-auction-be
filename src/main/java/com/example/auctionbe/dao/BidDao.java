package com.example.auctionbe.dao;

import com.example.auctionbe.entity.Bid;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Profile("db")
public interface BidDao {
    Bid getBid(Long id);
    List<Bid> getBids();
    Bid save(Bid bid);
}
