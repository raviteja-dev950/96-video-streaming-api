package com.videostreaming.service;

import com.videostreaming.entity.Video;
import com.videostreaming.repository.VideoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class VideoServiceTest {

    @Mock
    private VideoRepository videoRepository;

    @InjectMocks
    private VideoService videoService;

    private Video video;

    @BeforeEach
    void setUp() {
        video = new Video.Builder()
                .title("Test Video")
                .fileName("test.mp4")
                .contentType("video/mp4")
                .fileSize(1024L)
                .filePath("uploads/test.mp4")
                .uploadedAt(LocalDateTime.now())
                .build();
        video.setId(1L);
    }

    @Test
    public void testVideoEntityBuilderPattern() {
        Video built = new Video.Builder()
                .title("Builder Video")
                .fileName("builder.mp4")
                .contentType("video/mp4")
                .fileSize(2048L)
                .filePath("uploads/builder.mp4")
                .uploadedAt(LocalDateTime.now())
                .build();
        assertEquals("Builder Video", built.getTitle());
        assertEquals("builder.mp4", built.getFileName());
        System.out.println("Builder Pattern Test Passed: " + built.getTitle() + " - " + built.getFileName());
    }

    @Test
    public void testVideoEntity() {
        assertEquals("Test Video", video.getTitle());
        assertEquals("test.mp4", video.getFileName());
        assertEquals(1024L, video.getFileSize());
        System.out.println("Video Entity Test Passed: " + video.getTitle() + " - " + video.getFileName() + " - " + video.getFileSize() + " bytes");
    }

    @Test
    public void testFormatVideoInfo() {
        String formatted = videoService.formatVideoInfo(video);
        assertNotNull(formatted);
        assertTrue(formatted.contains("Test Video"));
        assertTrue(formatted.contains("test.mp4"));
        System.out.println("Format Video Test Passed: " + formatted);
    }

    @Test
    public void testGetVideoById_Mockito() {
        when(videoRepository.findById(1L)).thenReturn(Optional.of(video));
        Video found = videoService.getVideoById(1L);
        assertNotNull(found);
        assertEquals("Test Video", found.getTitle());
        verify(videoRepository, times(1)).findById(1L);
        System.out.println("Mockito Test Passed: getVideoById - Mocked Repo - Found: " + found.getTitle());
    }

    @Test
    public void testGetAllVideos_Mockito() {
        List<Video> mockList = Arrays.asList(video, video);
        when(videoRepository.findAllByOrderByUploadedAtDesc()).thenReturn(mockList);
        List<Video> result = videoService.getAllVideos();
        assertEquals(2, result.size());
        verify(videoRepository, times(1)).findAllByOrderByUploadedAtDesc();
        System.out.println("Mockito Test Passed: getAllVideos - Mocked 2 videos - Caching: videos");
    }

    @Test
    public void testSearchVideos_Mockito() {
        when(videoRepository.findByTitleContainingIgnoreCase("Test")).thenReturn(Arrays.asList(video));
        List<Video> result = videoService.searchVideos("Test");
        assertEquals(1, result.size());
        System.out.println("Search Test Passed: Found 1 video for keyword Test - Caching + Search");
    }
}