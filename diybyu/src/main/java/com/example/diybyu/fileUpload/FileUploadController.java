package com.example.diybyu.fileUpload;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(path="api/v1/project/")
@CrossOrigin(origins = "http://localhost:4200")
public class FileUploadController {


    @PostMapping("/uploadFile")
    public ResponseEntity<FileUploadResponse> uploadFile(
            @RequestParam("file") MultipartFile multipartFile
    ) throws IOException {

        //file name
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

        //file size
        Long size = multipartFile.getSize();

        //file code
        String fileCode = FileUploadUtility.saveFile(fileName, multipartFile);

        FileUploadResponse response = new FileUploadResponse();
        response.setFileName(fileName);
        response.setSize(size);
        response.setDownloadUri("downloadFile/"+fileCode);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
