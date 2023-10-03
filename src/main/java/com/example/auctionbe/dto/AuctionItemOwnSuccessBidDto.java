package com.example.auctionbe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuctionItemOwnSuccessBidDto {
    Long id;
    String owner;
    Double amount;
    String date;
}
