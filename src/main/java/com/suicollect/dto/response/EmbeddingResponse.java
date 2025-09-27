package com.suicollect.dto.response;

import com.suicollect.data.model.Embedding;
import lombok.Data;

@Data
public class EmbeddingResponse {
    private String message;
    private Embedding embedding;
}
