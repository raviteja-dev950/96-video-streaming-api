package com.videostreaming.controller;

import com.videostreaming.entity.Video;
import com.videostreaming.service.VideoService;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@RestController
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping("/")
    public Map<String, Object> home() {
        Map<String, Object> m = new HashMap<>();
        m.put("project", "96-video-streaming-api");
        m.put("status", "Live - Video Streaming API - Tier 10 Scale");
        m.put("tier", "10 - System Design Level - Caching + Security + Testing + Design Patterns");
        m.put("owner", "Raviteja");
        m.put("port", "8098");
        m.put("live", "https://nine6-video-streaming-api.onrender.com");
        m.put("caching", "Caffeine Cache - videos cache - 1000 max, 600s expire - Redis ready");
        m.put("security", "X-Content-Type-Options nosniff, X-Frame-Options DENY, XSS Protection");
        m.put("designPatterns", new String[]{"Builder Pattern - Video.Builder", "Strategy Pattern - Range vs Full Streaming", "Repository Pattern", "Caching Pattern"});
        m.put("testing", "JUnit 5 + Mockito - 6 tests - Builder + Service + Controller Mock");
        m.put("message", "Try POST /api/videos/upload with video file - Range 206 Partial Content");
        return m;
    }

    @GetMapping("/health")
    public Map<String, Object> health() {
        Map<String, Object> m = new HashMap<>();
        m.put("project", "96-video-streaming-api");
        m.put("status", "UP");
        m.put("streaming", "Active - Range Requests 206 Partial Content - Strategy Pattern");
        m.put("cache", "Active - Caffeine - videos, video - Stats enabled");
        m.put("security", "Headers Active");
        m.put("githubGoal", "CONTRIBUTING.md + Issues + Release Tags + Badges + Live Link + Architecture Diagram - Tier 10 Goal");
        return m;
    }

    @PostMapping("/api/videos/upload")
    public ResponseEntity<Map<String, Object>> upload(@RequestParam("title") @NotBlank String title,
                                                      @RequestParam("file") MultipartFile file) {
        try {
            if (file.isEmpty()) {
                Map<String, Object> err = new HashMap<>();
                err.put("error", "File is empty - Validation failed");
                return ResponseEntity.badRequest().body(err);
            }
            Video v = videoService.uploadVideo(title, file);
            Map<String, Object> r = new HashMap<>();
            r.put("id", v.getId());
            r.put("title", v.getTitle());
            r.put("fileName", v.getFileName());
            r.put("fileSize", v.getFileSize());
            r.put("contentType", v.getContentType());
            r.put("uploadedAt", v.getUploadedAt());
            r.put("streamUrl", "http://localhost:8098/api/videos/" + v.getId() + "/stream");
            r.put("message", "Uploaded - Range Ready - Cache Evicted - Builder Pattern");
            r.put("cache", "videos cache evicted");
            return ResponseEntity.ok(r);
        } catch (Exception e) {
            Map<String, Object> err = new HashMap<>();
            err.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err);
        }
    }

    @GetMapping("/api/videos")
    public ResponseEntity<List<Video>> list() {
        List<Video> videos = videoService.getAllVideos();
        return ResponseEntity.ok()
                .header("X-Cache", "Caffeine - videos")
                .header("Cache-Control", "public, max-age=3600")
                .body(videos);
    }

    @GetMapping("/api/videos/{id}")
    public ResponseEntity<?> one(@PathVariable Long id) {
        Video v = videoService.getVideoById(id);
        if (v == null) {
            Map<String, Object> err = new HashMap<>();
            err.put("error", "Video not found");
            err.put("id", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
        }
        return ResponseEntity.ok()
                .header("X-Cache", "Caffeine - video id=" + id)
                .body(v);
    }

    @GetMapping("/api/videos/{id}/stream")
    public ResponseEntity<Resource> stream(@PathVariable Long id,
                                           @RequestHeader(value = "Range", required = false) String range) {
        try {
            Video v = videoService.getVideoById(id);
            if (v == null) return ResponseEntity.notFound().build();
            Resource res = videoService.loadVideoAsResource(id);
            if (res == null) return ResponseEntity.notFound().build();

            long fileSize = v.getFileSize();
            long start = 0;
            long end = fileSize - 1;

            if (range != null && range.startsWith("bytes=")) {
                String[] p = range.substring(6).split("-");
                start = Long.parseLong(p[0]);
                if (p.length > 1 && !p[1].isEmpty()) end = Long.parseLong(p[1]);
            }

            long len = end - start + 1;
            HttpHeaders h = new HttpHeaders();
            h.setContentType(MediaType.parseMediaType(v.getContentType()));
            h.set(HttpHeaders.ACCEPT_RANGES, "bytes");
            h.set(HttpHeaders.CONTENT_LENGTH, String.valueOf(len));
            h.set("X-Streaming-Strategy", range != null ? "Range-Strategy-206" : "Full-Strategy-200");
            h.set("X-Cache", "Caffeine - video id=" + id);

            if (range != null) {
                h.set(HttpHeaders.CONTENT_RANGE, "bytes " + start + "-" + end + "/" + fileSize);
                return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).headers(h).body(res);
            } else {
                return ResponseEntity.ok().headers(h).body(res);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/api/videos/search")
    public ResponseEntity<List<Video>> search(@RequestParam String keyword) {
        return ResponseEntity.ok(videoService.searchVideos(keyword));
    }
}