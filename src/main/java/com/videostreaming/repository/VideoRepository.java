package com.videostreaming.repository;

import com.videostreaming.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface VideoRepository extends JpaRepository<Video, Long> {
    List<Video> findAllByOrderByUploadedAtDesc();
    Optional<Video> findByTitle(String title);
    List<Video> findByTitleContainingIgnoreCase(String keyword);
}