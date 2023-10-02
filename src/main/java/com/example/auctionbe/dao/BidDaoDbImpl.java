package com.example.auctionbe.dao;

import com.example.auctionbe.entity.Bid;
import com.example.auctionbe.repository.BidRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Profile("db")
public class BidDaoDbImpl implements BidDao {
    final BidRepository bidRepository;

    @Override
    public Bid getBid(Long id) {
        return bidRepository.findById(id).orElse(null);
    }
    @Override
    public List<Bid> getBids() {
        return bidRepository.findAll();
    }
    @Override
    public Bid save(Bid bid) {
        return bidRepository.save(bid);
    }
}
