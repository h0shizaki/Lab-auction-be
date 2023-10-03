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
        AuctionItem a1,a2,a3,a4,a5;
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
        a2 = auctionItemRepository.save(
                AuctionItem.builder()
                        .id(2L)
                        .name("Rare Bone")
                        .description("The Rare Bone serves no practical purpose other than to be sold.")
                        .owner("Miner A")
                        .date("03/Oct/2023")
                        .location("CNX Thailand")
                        .image("http://via.placeholder.com/360x360")
                        .type("Arts")
                        .build()
        );
        a3 = auctionItemRepository.save(
                AuctionItem.builder()
                        .id(3L)
                        .name("Focus Sash")
                        .description("if the holder has full HP and is hit by an attack that would otherwise cause fainting, can survive with only 1 HP")
                        .owner("Master Yi")
                        .date("03/Oct/2023")
                        .location("SG Singapore")
                        .type("Item")
                        .image("http://via.placeholder.com/360x360")
                        .build()
        );
        a4 = auctionItemRepository.save(
                AuctionItem.builder()
                        .id(4L)
                        .name("Light Ball")
                        .description("a held item that doubles both the Special Attack and Attack stats when held by a Pikachu")
                        .owner("Satoshi")
                        .date("03/Oct/2023")
                        .location("Tokyo Japan")
                        .type("Item")
                        .image("http://via.placeholder.com/360x360")
                        .build()
        );
        a5 = auctionItemRepository.save(
                AuctionItem.builder()
                        .id(5L)
                        .name("The Mill")
                        .description("The Mill is a painting by Dutch baroque artist Rembrandt Harmenszoon van Rijn")
                        .owner("Rembrandt")
                        .date("03/Oct/2023")
                        .location("Washington DC")
                        .type("Arts")
                        .image("https://en.wikipedia.org/wiki/File:DeMolenRembrandt.jpg")
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

        tempBid = (
                Bid.builder()
                        .id(3L)
                        .amount(Double.valueOf(800))
                        .owner("Kan")
                        .date("03/Oct/2023")
                        .auctionItem(a1)
                        .build()
        );
        a1.getOwnBids().add(tempBid);
        a1.setSuccessBid(tempBid);
        bidRepository.save(tempBid);
        auctionItemRepository.save(a1);

        tempBid = Bid.builder()
                .id(4L)
                .amount(Double.valueOf(550))
                .owner("Kan")
                .date("03/Oct/2023")
                .auctionItem(a2)
                .build();
        a2.getOwnBids().add(tempBid);
        bidRepository.save(tempBid);

        tempBid = (
                Bid.builder()
                        .id(5L)
                        .amount(Double.valueOf(600))
                        .owner("Joe")
                        .date("03/Oct/2023")
                        .auctionItem(a2)
                        .build()
        );
        a2.getOwnBids().add(tempBid);
        bidRepository.save(tempBid);

        tempBid = (
                Bid.builder()
                        .id(6L)
                        .amount(Double.valueOf(650.5))
                        .owner("Aster")
                        .date("03/Oct/2023")
                        .auctionItem(a2)
                        .build()
        );
        a2.getOwnBids().add(tempBid);
        bidRepository.save(tempBid);
        a2.setSuccessBid(tempBid);
        auctionItemRepository.save(a2);

        tempBid = (
                Bid.builder()
                        .id(7L)
                        .amount(Double.valueOf(100))
                        .owner("Kan")
                        .date("03/Oct/2023")
                        .auctionItem(a3)
                        .build()
        );
        a3.getOwnBids().add(tempBid);
        bidRepository.save(tempBid);

        tempBid = Bid.builder()
                .id(8L)
                .amount(Double.valueOf(250))
                .owner("Kan")
                .date("03/Oct/2023")
                .auctionItem(a3)
                .build();
        a3.getOwnBids().add(tempBid);
        bidRepository.save(tempBid);

        tempBid = (
                Bid.builder()
                        .id(9L)
                        .amount(Double.valueOf(400))
                        .owner("Joe")
                        .date("03/Oct/2023")
                        .auctionItem(a3)
                        .build()
        );
        a3.getOwnBids().add(tempBid);
        bidRepository.save(tempBid);
//        a3.setSuccessBid(tempBid);
        auctionItemRepository.save(a3);

        tempBid = (
                Bid.builder()
                        .id(10L)
                        .amount(Double.valueOf(1000))
                        .owner("Kan")
                        .date("03/Oct/2023")
                        .auctionItem(a4)
                        .build()
        );
        a4.getOwnBids().add(tempBid);
        bidRepository.save(tempBid);

        tempBid = Bid.builder()
                .id(11L)
                .amount(Double.valueOf(2500))
                .owner("Musashi")
                .date("03/Oct/2023")
                .auctionItem(a4)
                .build();
        a4.getOwnBids().add(tempBid);
        bidRepository.save(tempBid);

        tempBid = (
                Bid.builder()
                        .id(12L)
                        .amount(Double.valueOf(4000))
                        .owner("Joe")
                        .date("03/Oct/2023")
                        .auctionItem(a4)
                        .build()
        );
        a4.getOwnBids().add(tempBid);
        bidRepository.save(tempBid);
//        a4.setSuccessBid(tempBid);
        auctionItemRepository.save(a4);

        tempBid = (
                Bid.builder()
                        .id(13L)
                        .amount(Double.valueOf(1000))
                        .owner("Kan")
                        .date("03/Oct/2023")
                        .auctionItem(a5)
                        .build()
        );
        a5.getOwnBids().add(tempBid);
        bidRepository.save(tempBid);

        tempBid = Bid.builder()
                .id(14L)
                .amount(Double.valueOf(2500))
                .owner("Musashi")
                .date("03/Oct/2023")
                .auctionItem(a5)
                .build();
        a5.getOwnBids().add(tempBid);
        bidRepository.save(tempBid);

        tempBid = (
                Bid.builder()
                        .id(15L)
                        .amount(Double.valueOf(4000))
                        .owner("Joe")
                        .date("03/Oct/2023")
                        .auctionItem(a5)
                        .build()
        );
        a5.getOwnBids().add(tempBid);
        bidRepository.save(tempBid);
        a5.setSuccessBid(tempBid);
        auctionItemRepository.save(a5);
    }
}
