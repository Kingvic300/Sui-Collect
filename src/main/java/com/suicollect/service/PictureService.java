package com.suicollect.service;

import com.suicollect.data.model.Picture;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PictureService {
    Picture uploadPicture(MultipartFile file);
    List<Picture> getPictures(String userId);
}
