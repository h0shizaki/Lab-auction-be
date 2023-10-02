package com.example.auctionbe.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class AuctionItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String name;
    String type;
    String description;
    String owner;
    String date;
    String location;
    String image;

    @OneToMany(mappedBy = "auctionItem")
    @Builder.Default
    List<Bid> ownBids = new ArrayList<>();
}
