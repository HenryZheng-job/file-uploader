package com.henryzheng.entity;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by HenryZheng on 8/9/17.
 */

@Entity
@Table(name="uploaded_file")
public class UploadedFile implements Serializable {

    private static final long serialVersionUID = 8402760749L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="file_id")
    Integer fileId;

    @Column(name="file_name")
    String fileName;

    @Column(name="file_location")
    String fileLocation;

    @Column(name="file_size")
    Long fileSize;

    @Column(name="created_at")
    Long createdAt;



    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "UploadedFile: ["
                + getFileId() + ", "
                + getFileName() + ", "
                + getFileLocation() + ","
                + getCreatedAt() + ","
                + getFileSize() + "]";
    }
}
