package com.suicollect.service;

import com.suicollect.data.model.Collectible;
import com.suicollect.data.repository.CollectibleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CollectibleServiceImpl implements CollectibleService {

    private final CollectibleRepository collectibleRepository;
    private final CloudinaryService cloudinaryService;

    @Override
    public Collectible uploadCollectible(
            MultipartFile file,
            String itemName,
            String descriptionOne,
            String descriptionTwo,
            Double royalty,
            String nfcTagId
    ) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userId = authentication.getName(); // assuming principal name = userId or email

        try {
            String url = cloudinaryService.uploadPicture(file, userId);

            Collectible collectible = new Collectible();
            collectible.setUserId(userId);
            collectible.setImageUrl(url);
            collectible.setItemName(itemName);
            collectible.setDescriptionOne(descriptionOne);
            collectible.setDescriptionTwo(descriptionTwo);
            collectible.setRoyalty(royalty);
            collectible.setNfcTagId(nfcTagId);
            collectible.setCreatedAt(LocalDateTime.now());

            return collectibleRepository.save(collectible);
        } catch (IOException e) {
            throw new RuntimeException("Collectible upload failed", e);
        }
    }

    @Override
    public List<Collectible> getCollectibles(String userId) {
        return collectibleRepository.findByUserId(userId);
    }

    @Override
    public Collectible getByNfcTag(String nfcTagId) {
        return collectibleRepository.findByNfcTagId(nfcTagId)
                .orElseThrow(() -> new RuntimeException("Collectible not found for NFC tag: " + nfcTagId));
    }
}
