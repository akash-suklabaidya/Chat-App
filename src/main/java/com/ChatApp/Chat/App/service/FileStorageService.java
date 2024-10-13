package com.ChatApp.Chat.App.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileStorageService {

    private final String fileDirectory="uploads/";

    public String storeFile(MultipartFile file) throws IOException {
        String fileName=UUID.randomUUID().toString()+"_"+file.getOriginalFilename();
        String filePath=fileDirectory+fileName;
        File dir=new File(filePath);
        if(!dir.exists()){
            dir.mkdirs();
        }
        Files.copy(file.getInputStream(), Paths.get(filePath));
        return filePath;

    }

}
