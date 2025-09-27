package com.suicollect.mapper;

import com.suicollect.data.model.Embedding;
import com.suicollect.dto.response.EmbeddingResponse;

public class EmbeddingMapper {
    public static EmbeddingResponse mapToEmbeddingResponse(String message, Embedding embedding) {
        EmbeddingResponse embeddingResponse = new EmbeddingResponse();
        embeddingResponse.setMessage(message);
        embeddingResponse.setEmbedding(embedding);
        return embeddingResponse;
    }
}
