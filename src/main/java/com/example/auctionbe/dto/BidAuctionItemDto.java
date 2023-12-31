package com.example.auctionbe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BidAuctionItemDto {
    Long id;
    String name;
    String type;
    String description;
    String owner;
    String date;
    String location;
    String image;
}
