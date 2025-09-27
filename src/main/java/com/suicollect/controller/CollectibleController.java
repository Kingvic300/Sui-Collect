package com.suicollect.controller;

import com.suicollect.data.model.Collectible;
import com.suicollect.service.CollectibleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/collectibles")
@RequiredArgsConstructor
public class CollectibleController {

    private final CollectibleService collectibleService;

    @PostMapping
    public Collectible uploadCollectible(
            @RequestParam("file") MultipartFile file,
            @RequestParam("itemName") String itemName,
            @RequestParam("descriptionOne") String descriptionOne,
            @RequestParam("descriptionTwo") String descriptionTwo,
            @RequestParam("royalty") Double royalty,
            @RequestParam("nfcTagId") String nfcTagId
    ) {
        return collectibleService.uploadCollectible(file, itemName, descriptionOne, descriptionTwo, royalty, nfcTagId);
    }

    @GetMapping("/{userId}")
    public List<Collectible> getCollectibles(@PathVariable String userId) {
        return collectibleService.getCollectibles(userId);
    }

    @GetMapping("/nfc/{nfcTagId}")
    public Collectible getByNfcTag(@PathVariable String nfcTagId) {
        return collectibleService.getByNfcTag(nfcTagId);
    }
}
