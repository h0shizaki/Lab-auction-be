package com.example.auctionbe.repository;

import com.example.auctionbe.entity.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BidRepository  extends JpaRepository<Bid, Long> {
    List<Bid> findAll() ;
}
