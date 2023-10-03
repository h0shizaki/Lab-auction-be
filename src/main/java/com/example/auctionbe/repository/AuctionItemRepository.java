package com.example.auctionbe.repository;

import com.example.auctionbe.entity.AuctionItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuctionItemRepository extends JpaRepository<AuctionItem, Long> {
    List<AuctionItem> findAll();
    Page<AuctionItem> findByNameContainingOrDescriptionContaining(String name, String description, Pageable pageRequest);
    Page<AuctionItem> findBySuccessBidAmountLessThan(Double amount, Pageable pageRequest);

}
