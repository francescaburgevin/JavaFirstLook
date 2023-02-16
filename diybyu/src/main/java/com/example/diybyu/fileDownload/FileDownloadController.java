package com.example.diybyu.fileDownload;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Path;

@RestController
@RequestMapping(path="api/v1/project/")
@CrossOrigin(origins = "http://localhost:4200")
public class FileDownloadController {

    FileDownloadUtility downloadUtil = new FileDownloadUtility();

    @GetMapping("/downloadFile/{fileCode}")
    public ResponseEntity<?> downloadFile(@PathVariable("fileCode") String fileCode) {


        Resource resource = null;
        try {
            resource = downloadUtil.getFileAsResource(fileCode);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }

        if (resource == null) {
            return new ResponseEntity<>("File not found", HttpStatus.NOT_FOUND);
        }

        String contentType = "application/octet-stream";
        String headerValue = "attachment; filename=\"" + resource.getFilename() + "\"";

        System.out.println(resource);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
                .body(resource);
    }


    public @ResponseBody Path getImageWithMediaType(@PathVariable(name = "imageName") String fileName) throws IOException {
        return this.downloadUtil.getImageWithMediaType(fileName);
    }
}
