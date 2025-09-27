package com.suicollect.data.repository;

import com.suicollect.data.model.Picture;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PictureRepository extends MongoRepository<Picture, String> {
    List<Picture> findByUserId(String userId);
}
