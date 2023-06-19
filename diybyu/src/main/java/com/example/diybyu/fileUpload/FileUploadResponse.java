package com.example.diybyu.fileUpload;

public class FileUploadResponse {

    private String name;
    private String downloadUri;
    private long size;

    //empty constructor
    public FileUploadResponse() {
    }

    //constructor full
    public FileUploadResponse(String name, String downloadUri, Long size) {
        this.name = name;
        this.downloadUri = downloadUri;
        this.size = size;
    }

    //getters & setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("Set file name to : "+this.name);
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
