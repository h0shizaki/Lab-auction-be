package com.example.auctionbe.service;

import com.example.auctionbe.dao.AuctionItemDao;
import com.example.auctionbe.dao.BidDao;
import com.example.auctionbe.entity.AuctionItem;
import com.example.auctionbe.entity.Bid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BidServiceImpl implements BidService{
    AuctionItemDao auctionItemDao;
    final BidDao bidDao;
    @Override
    public Bid getBid(Long id) {
        return bidDao.getBid(id);
    }

    @Override
    public List<Bid> getBids(){
        return  bidDao.getBids();
    }

    @Override
    public Bid save(Bid bid) {
        AuctionItem auctionItem = auctionItemDao.getAuctionItem(bid.getAuctionItem().getId());
        bid.setAuctionItem(auctionItem);
        auctionItem.getOwnBids().add(bid);
        return bidDao.save(bid);
    }


}
