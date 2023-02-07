package com.example.diybyu.fileUpload;

public class FileUploadResponse {

    private String fileName;
    private String downloadUri;
    private long size;

    //empty constructor
    public FileUploadResponse() {
    }

    //constructor full
    public FileUploadResponse(String fileName, String downloadUri, long size) {
        this.fileName = fileName;
        this.downloadUri = downloadUri;
        this.size = size;
    }

    //getters & setters
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
        System.out.println(this.fileName);
    }

    public String getDownloadUri() {
        return downloadUri;
    }

    public void setDownloadUri(String downloadUri) {
        this.downloadUri = downloadUri;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
