package com.example.auctionbe.dao;

import com.example.auctionbe.entity.AuctionItem;
import com.example.auctionbe.repository.AuctionItemRepository;
import com.example.auctionbe.service.AuctionItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Profile("db")
public class AuctionItemDaoDbImpl implements AuctionItemDao{
    final AuctionItemRepository auctionItemRepository;

    @Override
    public Integer getAuctionItemSize() {
        return Math.toIntExact(auctionItemRepository.count() );
    }

    @Override
    public Page<AuctionItem> getAuctionItems(Integer perPage, Integer page) {
        page = page == null ? 1 : page;
        perPage = perPage == null ? this.getAuctionItemSize() : perPage;
        return auctionItemRepository.findAll(PageRequest.of(page - 1, perPage));
    }

    @Override
    public AuctionItem getAuctionItem(Long id){
        return auctionItemRepository.findById(id).orElse(null);
    }

    @Override
    public AuctionItem save(AuctionItem auctionItem){
        return auctionItemRepository.save(auctionItem);
    }
}
