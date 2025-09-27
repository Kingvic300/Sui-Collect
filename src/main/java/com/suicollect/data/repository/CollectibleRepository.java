package com.suicollect.data.repository;

import com.suicollect.data.model.Collectible;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CollectibleRepository extends MongoRepository<Collectible, String> {
    List<Collectible> findByUserId(String userId);
    Optional<Collectible> findByNfcTagId(String nfcTagId);
}
