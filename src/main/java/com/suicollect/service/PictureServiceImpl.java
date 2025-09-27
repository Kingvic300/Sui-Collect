package com.suicollect.service;

import com.suicollect.data.model.Picture;
import com.suicollect.data.repository.PictureRepository;
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
public class PictureServiceImpl implements PictureService {

    private final PictureRepository pictureRepository;
    private final CloudinaryService cloudinaryService;

    @Override
    public Picture uploadPicture(MultipartFile file) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userId = authentication.getName();

        try {
            String url = cloudinaryService.uploadPicture(file, userId);

            Picture picture = new Picture();
            picture.setUserId(userId);
            picture.setImageUrl(url);
            picture.setCreatedAt(LocalDateTime.now());

            return pictureRepository.save(picture);
        } catch (IOException e) {
            throw new RuntimeException("Picture upload failed", e);
        }
    }

    @Override
    public List<Picture> getPictures(String userId) {
        return pictureRepository.findByUserId(userId);
    }
}
