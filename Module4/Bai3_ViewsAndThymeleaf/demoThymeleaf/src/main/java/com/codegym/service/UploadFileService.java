package com.codegym.service;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class UploadFileService {
    public void uploadFile(MultipartFile file) throws IOException {
        String folderUpload = "D:\\TaiLieuModule4\\Module4\\Bai3_ViewsAndThymeleaf\\demoThymeleaf\\src\\main\\webapp\\uploadFile\\";
        String fileName = file.getOriginalFilename();
        FileCopyUtils.copy(file.getBytes() , new File(folderUpload + fileName));
    }
}
