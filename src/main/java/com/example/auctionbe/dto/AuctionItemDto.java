package com.example.auctionbe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuctionItemDto {
    Long id;
    String name;
    String type;
    String description;
    String owner;
    String date;
    String location;
    String image;
    List<AuctionItemOwnBidsDto> ownBids = new ArrayList<>() ;
    AuctionItemOwnSuccessBidDto successBid = null ;
}
