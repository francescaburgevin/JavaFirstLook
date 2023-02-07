package com.example.diybyu.fileUpload;
//package net.codejava.upload;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {
    public static String saveFile(String fileName, MultipartFile multipartFile)
            throws IOException {
        Path uploadPath = Paths.get("Files-Upload");
        System.out.println("started saveFile in FileUploadUtility");
        //if directory does not exist, create
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        //inserts 8 alphanumeric characters before the file name...
        //do not want this, want to replace fileName with date milliseconds
        String fileCode = RandomStringUtils.randomAlphanumeric(8);

        try (InputStream inputStream = multipartFile.getInputStream()) {

            // ... so in the file download API it can identify a file based on an identifier
            Path filePath = uploadPath.resolve(fileCode + "-" + fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {
            throw new IOException("Could not save file: " + fileName, ioe);
        }

        //the method returns the fileCode which is then used in download URI field of the response body
        return fileCode;
    }
}


