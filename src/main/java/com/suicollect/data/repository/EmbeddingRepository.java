package com.suicollect.data.repository;

import com.suicollect.data.model.Embedding;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmbeddingRepository extends MongoRepository<Embedding , String> {
}
