package com.fileupload.fileupload.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="filedata")
public class DBFile {

private String id;
private String fileName;
private String fileType;
private String title;
private byte[] data;

    public DBFile() {
    }



    public DBFile(String fileName, String fileType, byte[] data, String title) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.title = title;
        this.data = data;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
