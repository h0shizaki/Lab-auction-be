package com.example.auctionbe.config;

import com.example.auctionbe.entity.AuctionItem;
import com.example.auctionbe.entity.Bid;
import com.example.auctionbe.repository.AuctionItemRepository;
import com.example.auctionbe.repository.BidRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final AuctionItemRepository auctionItemRepository;
    final BidRepository bidRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        AuctionItem a1;
        a1 = auctionItemRepository.save(
                AuctionItem.builder()
                        .id(1L)
                        .name("Aisha Image")
                        .description("Green Cat Picture")
                        .owner("Aisha")
                        .date("02/Oct/2023")
                        .location("BKK Thailand")
                        .image("https://cdn.waifu.im/1546.png")
                        .type("Arts")
                        .build()
        );

        Bid tempBid;
        tempBid = Bid.builder()
                .id(1L)
                .amount(Double.valueOf(500))
                .owner("Kan")
                .date("03/Oct/2023")
                .auctionItem(a1)
                .build();
        a1.getOwnBids().add(tempBid);
        bidRepository.save(tempBid);

        tempBid = (
                Bid.builder()
                        .id(2L)
                        .amount(Double.valueOf(600))
                        .owner("Aster")
                        .date("03/Oct/2023")
                        .auctionItem(a1)
                        .build()
        );
        a1.getOwnBids().add(tempBid);
        bidRepository.save(tempBid);

    }
}
