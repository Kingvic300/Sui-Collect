package com.suicollect.data.repository;

import com.suicollect.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByAuthProviderId(String authProviderId);
    Optional<User> findByEmail(String email);

    Optional<User> findByWalletAddress(String walletAddress);
}
