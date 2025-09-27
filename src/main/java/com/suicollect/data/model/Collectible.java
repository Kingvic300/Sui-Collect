package com.suicollect.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDateTime;

@Document(collection = "collectibles")
@Data
public class Collectible {
    @Id
    private String id;

    private String userId; // store reference, not whole User object

    private String imageUrl;

    private String itemName;

    private String descriptionOne;

    private String descriptionTwo;

    private Double royalty; // store SUI royalty or % as double

    @Indexed(unique = true)
    private String nfcTagId;

    private LocalDateTime createdAt;
}
