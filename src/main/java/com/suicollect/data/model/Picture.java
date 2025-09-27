package com.suicollect.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "pictures")
@Data
public class Picture {
    @Id
    private String id;

    private String userId;

    private String imageUrl;

    private LocalDateTime createdAt;
}
