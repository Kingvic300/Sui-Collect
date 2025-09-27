package com.suicollect.service;

import com.suicollect.data.model.Collectible;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CollectibleService {
    Collectible uploadCollectible(
            MultipartFile file,
            String itemName,
            String descriptionOne,
            String descriptionTwo,
            Double royalty,
            String nfcTagId
    );

    List<Collectible> getCollectibles(String userId);

    Collectible getByNfcTag(String nfcTagId);
}
