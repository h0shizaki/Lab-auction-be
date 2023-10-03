package com.example.auctionbe.service;

import com.example.auctionbe.dao.AuctionItemDao;
import com.example.auctionbe.dao.BidDao;
import com.example.auctionbe.entity.AuctionItem;
import com.example.auctionbe.entity.Bid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuctionItemServiceImpl implements AuctionItemService {
    final AuctionItemDao auctionItemDao;
    final BidDao bidDao;

    @Override
    public Integer getAuctionItemSize() {
        return this.auctionItemDao.getAuctionItemSize();
    }

    @Override
    public Page<AuctionItem> getAuctionItems(Integer perPage, Integer page) {
        return this.auctionItemDao.getAuctionItems(perPage, page);
    }

    @Override
    public Page<AuctionItem> getAuctionItems(String title, Pageable pageRequest) {
        return this.auctionItemDao.getAuctionItems(title, pageRequest);
    }
    @Override
    public Page<AuctionItem> getAuctionItems(Double amount, Pageable pageRequest) {
        return this.auctionItemDao.getAuctionItems(amount, pageRequest);
    }

    @Override
    public AuctionItem getAuctionItem(Long id) {
        return this.auctionItemDao.getAuctionItem(id);
    }

    @Override
    public AuctionItem save(AuctionItem auctionItem) {
        try {
            Bid bid = bidDao.getBid(auctionItem.getSuccessBid().getId());
            auctionItem.setSuccessBid(bid);
            return auctionItemDao.save(auctionItem);

        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return auctionItemDao.save(auctionItem);
    }
}
