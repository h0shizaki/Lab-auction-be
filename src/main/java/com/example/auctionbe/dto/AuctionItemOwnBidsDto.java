package com.example.auctionbe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuctionItemOwnBidsDto {
    Long id;
    String owner;
    Double amount;
    String date;
}
