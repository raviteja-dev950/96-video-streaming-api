package com.videostreaming.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "video", indexes = {@Index(name="idx_title", columnList="title")})
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String title;

    @NotBlank
    @Column(nullable = false)
    private String fileName;

    @Column(nullable = false)
    private String contentType;

    private Long fileSize;
    private String filePath;
    private LocalDateTime uploadedAt;
    private Long viewCount = 0L;

    // Builder Pattern - Tier 10 Design Pattern
    public static class Builder {
        private final Video v = new Video();
        public Builder title(String t){ v.setTitle(t); return this; }
        public Builder fileName(String f){ v.setFileName(f); return this; }
        public Builder contentType(String c){ v.setContentType(c); return this; }
        public Builder fileSize(Long s){ v.setFileSize(s); return this; }
        public Builder filePath(String p){ v.setFilePath(p); return this; }
        public Builder uploadedAt(LocalDateTime time){ v.setUploadedAt(time); return this; }
        public Video build(){ return v; }
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }
    public String getContentType() { return contentType; }
    public void setContentType(String contentType) { this.contentType = contentType; }
    public Long getFileSize() { return fileSize; }
    public void setFileSize(Long fileSize) { this.fileSize = fileSize; }
    public String getFilePath() { return filePath; }
    public void setFilePath(String filePath) { this.filePath = filePath; }
    public LocalDateTime getUploadedAt() { return uploadedAt; }
    public void setUploadedAt(LocalDateTime uploadedAt) { this.uploadedAt = uploadedAt; }
    public Long getViewCount() { return viewCount; }
    public void setViewCount(Long v){ this.viewCount=v; }
}