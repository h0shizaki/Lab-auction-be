package com.example.auctionbe.util;

import com.example.auctionbe.dao.BidDao;
import com.example.auctionbe.dto.AuctionItemDto;
import com.example.auctionbe.dto.BidDto;
import com.example.auctionbe.entity.AuctionItem;
import com.example.auctionbe.entity.Bid;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);
    AuctionItemDto getAuctionItemDTO(AuctionItem auctionItem);
    List<AuctionItemDto> getAuctionItemDTO(List<AuctionItem> auctionItems);
    BidDto getBitDTO(Bid bid);
    List<BidDto> getBitDTO(List<Bid> bid);

}
