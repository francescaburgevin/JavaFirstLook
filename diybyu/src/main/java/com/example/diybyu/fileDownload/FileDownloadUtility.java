package com.example.diybyu.fileDownload;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDownloadUtility {

    private Path foundFile;
    private Path dirPath;

    public Resource getFileAsResource(String fileCode) throws IOException {
        this.dirPath = Paths.get("uploaded_images");

        Files.list(dirPath).forEach(file -> {
            if (file.getFileName().toString().startsWith(fileCode)) {
                foundFile = file;
                return;
            }
        });

        if (foundFile != null) {
            return new UrlResource(foundFile.toUri());
        }

        return null;
    }





    public Path getImageWithMediaType(String imageName) throws IOException {
        Path destination =   Paths.get(this.dirPath+"\\"+imageName);// retrieve the image by its name
        return destination;
    }
}
