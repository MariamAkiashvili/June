package com.example.demoInertia.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demoInertia.model.Organization;
import com.example.demoInertia.service.UploadImageService;

@RestController
@RequestMapping("/Upload")
@CrossOrigin
public class UploadOrganizationImagesController {

    @Autowired 
    UploadImageService uploadImageService;
    
    @PostMapping("/Image")
    public String handleImageUpload( @RequestParam("organizationId") int organizationId, 
                                    @RequestParam("files") MultipartFile[] file) throws IOException{


        // int id = Integer.parseInt(StringOrganizationId);
        for (MultipartFile f : file){
            uploadImageService.uploadFile(f, organizationId);
        }
        
        return "Upload completed successfully";
    }
}
