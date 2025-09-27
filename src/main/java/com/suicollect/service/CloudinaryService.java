package com.suicollect.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CloudinaryService {
    String uploadFile(MultipartFile multipartFile) throws IOException;
    String uploadPicture(MultipartFile file, String userId) throws IOException;

}
