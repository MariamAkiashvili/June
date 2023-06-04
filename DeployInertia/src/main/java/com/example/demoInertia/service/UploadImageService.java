package com.example.demoInertia.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.example.demoInertia.model.Organization;

// import com.example.demoInertia.model.Organization;


public interface UploadImageService {
    public void uploadFile(MultipartFile file, int organizationId) throws IOException;
}
