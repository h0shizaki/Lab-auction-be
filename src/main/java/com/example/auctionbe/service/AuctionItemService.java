package com.example.auctionbe.service;

import com.example.auctionbe.entity.AuctionItem;
import org.springframework.data.domain.Page;

public interface AuctionItemService {
    Integer getAuctionItemSize();
    Page<AuctionItem> getAuctionItems(Integer perPage, Integer page);
    AuctionItem getAuctionItem(Long id);
    AuctionItem save(AuctionItem auctionItem);
}
