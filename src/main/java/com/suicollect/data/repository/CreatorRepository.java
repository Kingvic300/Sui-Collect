package com.suicollect.data.repository;

import com.suicollect.data.model.Creator;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CreatorRepository extends MongoRepository<Creator, String> {
    Optional<Creator> findByWalletAddress(String walletAddress);
}
