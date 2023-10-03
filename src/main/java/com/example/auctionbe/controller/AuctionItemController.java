package com.example.auctionbe.controller;

import com.example.auctionbe.entity.AuctionItem;
import com.example.auctionbe.service.AuctionItemService;
import com.example.auctionbe.util.LabMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequiredArgsConstructor
public class AuctionItemController {
    final AuctionItemService auctionItemService;

    @GetMapping("items")
    public ResponseEntity<?> getAuctionItemList(@RequestParam(value = "_limit", required = false) Integer perPage,
                                                @RequestParam(value = "_page", required = false) Integer page,
                                                @RequestParam(value = "title", required = false) String title,
                                                @RequestParam(value = "price", required = false) Double amount ) {
        perPage = perPage == null ? auctionItemService.getAuctionItemSize() : perPage;
        page = page == null ? 1 : page;
        Page<AuctionItem> pageOutput;

        if (title != null) {
            pageOutput = auctionItemService.getAuctionItems(title, PageRequest.of(page - 1, perPage));
        }else if (amount != null){
            pageOutput = auctionItemService.getAuctionItems(amount, PageRequest.of(page - 1, perPage));
        }
        else {
            pageOutput = auctionItemService.getAuctionItems(perPage, page);
        }
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new
                ResponseEntity<>(LabMapper.INSTANCE.getAuctionItemDTO(pageOutput.getContent()), responseHeader, HttpStatus.OK);
    }

    @GetMapping("items/{id}")
    public ResponseEntity<?> getAuctionItemById(@PathVariable("id") Long id) {
        AuctionItem auctionItem = auctionItemService.getAuctionItem(id);
        if (auctionItem != null) {
            return ResponseEntity.ok(LabMapper.INSTANCE.getAuctionItemDTO(auctionItem));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }
}
