package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

public class Upload {
    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
