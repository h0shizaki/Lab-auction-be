package com.example.auctionbe.dao;

import com.example.auctionbe.entity.AuctionItem;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

@Profile("db")
public interface AuctionItemDao {
    Integer getAuctionItemSize();
    Page<AuctionItem> getAuctionItems(Integer perPage, Integer page);
    AuctionItem getAuctionItem(Long id);
    AuctionItem save(AuctionItem auctionItem);
}
