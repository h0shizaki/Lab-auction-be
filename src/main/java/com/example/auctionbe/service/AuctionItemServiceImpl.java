package com.example.auctionbe.service;

import com.example.auctionbe.dao.AuctionItemDao;
import com.example.auctionbe.entity.AuctionItem;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuctionItemServiceImpl implements AuctionItemService{
    final AuctionItemDao auctionItemDao;
    @Override
    public Integer getAuctionItemSize() {
        return this.auctionItemDao.getAuctionItemSize();
    }

    @Override
    public Page<AuctionItem> getAuctionItems(Integer perPage, Integer page) {
        return this.auctionItemDao.getAuctionItems(perPage, page);
    }

    @Override
    public AuctionItem getAuctionItem(Long id) {
        return  this.auctionItemDao.getAuctionItem(id);
    }

    @Override
    public AuctionItem save(AuctionItem auctionItem){
        return auctionItemDao.save(auctionItem);
    }
}
