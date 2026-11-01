package com.videostreaming.service;

import com.videostreaming.entity.Video;
import com.videostreaming.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;

    private final Path rootLocation = Paths.get("uploads");

    public VideoService() {
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new RuntimeException("Could not init storage", e);
        }
    }

    @CacheEvict(value = "videos", allEntries = true)
    public Video uploadVideo(String title, MultipartFile file) throws IOException {
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path dest = rootLocation.resolve(fileName);
        Files.copy(file.getInputStream(), dest, StandardCopyOption.REPLACE_EXISTING);

        Video video = new Video.Builder()
                .title(title)
                .fileName(file.getOriginalFilename())
                .contentType(file.getContentType() != null ? file.getContentType() : "video/mp4")
                .fileSize(file.getSize())
                .filePath(dest.toString())
                .uploadedAt(LocalDateTime.now())
                .build();

        return videoRepository.save(video);
    }

    @Cacheable(value = "videos")
    public List<Video> getAllVideos() {
        return videoRepository.findAllByOrderByUploadedAtDesc();
    }

    @Cacheable(value = "video", key = "#id")
    public Video getVideoById(Long id) {
        return videoRepository.findById(id).orElse(null);
    }

    public Resource loadVideoAsResource(Long id) throws MalformedURLException {
        Video video = getVideoById(id);
        if (video == null) return null;
        Path file = Paths.get(video.getFilePath());
        Resource resource = new UrlResource(file.toUri());
        if (resource.exists()) return resource;
        return null;
    }

    public String formatVideoInfo(Video video) {
        return "[" + video.getUploadedAt() + "] " + video.getTitle() + " - " + video.getFileName() + " (" + video.getFileSize() + " bytes) Views:" + video.getViewCount();
    }

    public List<Video> searchVideos(String keyword) {
        return videoRepository.findByTitleContainingIgnoreCase(keyword);
    }
}