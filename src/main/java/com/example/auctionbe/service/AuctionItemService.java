package com.example.auctionbe.service;

import com.example.auctionbe.entity.AuctionItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AuctionItemService {
    Integer getAuctionItemSize();

    Page<AuctionItem> getAuctionItems(Integer perPage, Integer page);

    Page<AuctionItem> getAuctionItems(String title, Pageable pageRequest);
    Page<AuctionItem> getAuctionItems(Double amount, Pageable pageRequest);

    AuctionItem getAuctionItem(Long id);

    AuctionItem save(AuctionItem auctionItem);
}
