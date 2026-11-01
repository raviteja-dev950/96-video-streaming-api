# 🚀 Project 96 – Video Streaming API | System Design Level | Full Stack DevOps

[Java 17](https://img.shields.io/badge/Java-17-E76F00?logo=openjdk&logoColor=white)
[Spring Boot 3.2.5](https://img.shields.io/badge/Spring%20Boot-3.2.5-6DB33F?logo=springboot&logoColor=white)
[Caching](https://img.shields.io/badge/Caching-Caffeine%201000%20max%20600s%20expire%20Stats-blue?logo=redis&logoColor=white)
[Cache Stats](https://img.shields.io/badge/Cache%20Stats-recordStats%20enabled-brightgreen)
[Security](https://img.shields.io/badge/Security-Headers%20nosniff%20DENY%20XSS-red?logo=springsecurity&logoColor=white)
[Builder Pattern](https://img.shields.io/badge/Builder%20Pattern-Video.Builder%20Fluent%20API-success?logo=java&logoColor=white)
[Strategy Pattern](https://img.shields.io/badge/Strategy%20Pattern-Range%20206%20vs%20Full-yellow?logo=youtube&logoColor=white)
[Repository Pattern](https://img.shields.io/badge/Repository%20Pattern-JpaRepository-6DB33F)
[H2 Database](https://img.shields.io/badge/H2-Database%20videodb-003545?logo=h2&logoColor=white)
[viewCount](https://img.shields.io/badge/viewCount-Added%20%2B%20idx__title-orange)
[JUnit 5](https://img.shields.io/badge/JUnit-5%206%2F6%20Green-25A162?logo=junit5&logoColor=white)
[Mockito](https://img.shields.io/badge/Mockito-Mocked%20Repo%20when%2Fverify-00BFFF)
[Range 206](https://img.shields.io/badge/Range-206%20Partial%20Content%20%2B%20Content--Range-blueviolet?logo=http&logoColor=white)
[Docker](https://img.shields.io/badge/Docker-Multi--Stage-2496ED?logo=docker&logoColor=white)
[Render](https://img.shields.io/badge/Render-Live%202m32s-brightgreen?logo=render&logoColor=white)
[Tomcat](https://img.shields.io/badge/Apache%20Tomcat-10.1.20-D4AF00?logo=apachetomcat&logoColor=white)
[Port](https://img.shields.io/badge/Port-8098-00BFFF)
[Status](https://img.shields.io/badge/Status-Video%20Streaming%20Live%20Tier%2010-brightgreen)
[Tier 10](https://img.shields.io/badge/Tier%2010-System%20Design%20Level%20SCALE-blueviolet)

**Live URL:** https://nine6-video-streaming-api.onrender.com/

[[Live](https://img.shields.io/badge/Live-Render-brightgreen?style=for-the-badge&logo=render)](https://nine6-video-streaming-api.onrender.com)

Project 96 - Part of Java 102 Projects Challenge - System Design Level Tier 10 SCALE
---
**TIER 10 SCALE 96/102 - 94%**
---

# 📖 Project Overview

**Video Streaming API** is Project 96 of **Tier 10 – System Design Level – SCALE PROJECT**, developed using **Java 17**, **Spring Boot 3.2.5**, **Spring Cache Caffeine (CaffeineCacheManager maximumSize=1000 expireAfterAccess=600s recordStats() - Redis pattern ready)**, **Security Headers (SecurityHeadersConfig WebMvcConfigurer + HandlerInterceptor X-Content-Type-Options nosniff + X-Frame-Options DENY + X-XSS-Protection)**, **Design Patterns (Builder Pattern Video.Builder Fluent API + Strategy Pattern Range vs Full 206 Partial Content + Repository Pattern JpaRepository + Caching Pattern Cache-aside)**, **Spring Data JPA**, **H2 Database videodb + view_count + idx_title index**, **JUnit 5 + Mockito 6 tests Green Bar**, **Docker Multi-Stage (maven:3.9-eclipse-temurin-17 + eclipse-temurin:17-jdk-alpine + mkdir -p uploads)**, **Maven**, and **Apache Tomcat 10.1.20** in a **production System Design ready repo**.

Spring Boot REST API running on port 8098 locally (10000 on Render) with 5 endpoints + streaming `GET / returns live JSON {"project":"96-video-streaming-api","status":"Live - Video Streaming API - Tier 10 Scale","tier":"10 - System Design Level - Caching + Security + Testing + Design Patterns","caching":"Caffeine Cache - videos cache - 1000 max, 600s expire - Redis ready","security":"X-Content-Type-Options nosniff, X-Frame-Options DENY, XSS Protection","designPatterns":["Builder Pattern - Video.Builder","Strategy Pattern - Range vs Full Streaming","Repository Pattern","Caching Pattern"],"testing":"JUnit 5 + Mockito - 6 tests"}`, `GET /health -> {"status":"UP","cache":"Active - Caffeine - videos, video - Stats enabled","security":"Headers Active","streaming":"Active - Range Requests 206 Partial Content - Strategy Pattern"}`, `POST /api/videos/upload form-data title + file -> 200 OK {id, title, fileName, fileSize, message: Uploaded - Range Ready - Cache Evicted - Builder Pattern, cache: videos cache evicted, streamUrl}`, `GET /api/videos -> List Video with id title fileName contentType fileSize filePath uploadedAt viewCount + X-Cache: Caffeine header`, `GET /api/videos/{id}/stream -> Range: bytes=0-1023 header -> 206 Partial Content + Content-Range: bytes 0-1023/71909571 + Accept-Ranges: bytes + X-Streaming-Strategy: Range-Strategy-206 + 1.45KB chunk else 200 OK Full`, `GET /api/videos/search?keyword=Test -> Search by titleContainingIgnoreCase - Elasticsearch pattern ready`. This repo contains **Video.java Entity with Builder inner class**, **VideoRepository.java (findAllByOrderByUploadedAtDesc + findByTitleContainingIgnoreCase + idx_title)**, **VideoService.java (Builder Pattern upload + Cacheable videos + Cacheable video + CacheEvict + viewCount + idx_title)**, **CacheConfig.java (CaffeineCacheManager 1000 max 600s expire Stats Redis ready)**, **SecurityHeadersConfig.java (Interceptor nosniff DENY XSS Protection)**, **VideoController.java (5 endpoints + Range 206 Strategy + X-Cache + X-Streaming-Strategy + Content-Range)**, **VideoServiceTest (JUnit 5 + Mockito 6 tests green)** - eliminating manual run only. One `git push` gives full Video Streaming live. Local uses `H2 in-memory` for video metadata, `uploads/` directory for 71MB files, on Production same auto.

This is Project 96 of Tier 10 - SCALE - After Chat App WebSockets (95), now real System Design base for Search with Elastic (97).

**Bug Fixed:** `Cannot load driver class: org.h2.Driver` - H2 scope runtime - Fixed by removing `<scope>runtime</scope>` + Maven Update Project + Force Update - Same pattern as Tier 9 H2 fix - 94 + 95 also.

**Bug Fixed:** `Unable to resolve name [org.hibernate.dialect.H2Dialect ] as strategy` - Extra newline space in application.properties - Fixed by removing `spring.jpa.database-platform` + `spring.datasource.driverClassName` lines + Let Spring Boot auto-detect dialect - BUILD SUCCESS 13.014 sec.

**Bug Fixed:** `URL must start with 'jdbc'` - Typo `dbc:h2:mem:videodb` missing `j` - `spring.datasource.url=dbc:h2:mem:videodb` instead of `jdbc:h2:mem:videodb` - Fixed by correcting to `jdbc:h2:mem:videodb` + Removed driverClassName + database-platform (Tier 9 pattern) - BUILD SUCCESS 16.708s then 13.014s Tier 10.

**Bug Fixed:** `VideoController.java red errors - cannot find symbol Cacheable, CaffeineCacheManager` - META-INF folder bug - Eclipse creates `src/main/resources/META-INF` folder breaking Maven + Maven dependencies not downloaded (caffeine, cache, H2, JUnit5, Mockito) - Fixed by deleting META-INF folder + deleting target folder + Maven -> Update Project -> Force Update -> Wait dependencies download - Same as 93/94/95 META-INF bug.

**Bug Fixed:** `docker.io/library/openjdk:17-jdk-slim: not found` - OpenJDK image deleted from Docker Hub - Fixed by changing to `eclipse-temurin:17-jdk-alpine` - Render Deploy failed - Same as 94 + 95.

**Bug Fixed:** `COPY target/*.jar app.jar ERROR: lstat /target: no such file or directory` - Docker build doesn't run mvn package - Fixed by using Multi-Stage Dockerfile `FROM maven:3.9-eclipse-temurin-17 AS build + COPY pom.xml + COPY src + RUN mvn clean package -DskipTests + FROM eclipse-temurin:17-jdk-alpine + mkdir -p uploads + COPY --from=build /app/target/*.jar app.jar` - Deploy succeeded 2m32s Live - Same as 94 + 95.

**Bug Fixed:** `uploads/ directory not found - FileNotFoundException on upload` - Docker final stage no uploads folder - Fixed by `mkdir -p uploads` in Dockerfile + `.gitignore` + `file.getOriginalFilename()` save to `uploads/` + `filePath` field - Video upload working.

**Bug Fixed:** `Was 2/2 tests Tier 5 - Not Tier 10 compliant` - Only Entity + Format tests - No Builder + No Mockito Mock Repo + No Caching + No Security + No Design Patterns + No CONTRIBUTING.md + No Issues + No Badges - Fixed by rebuilding to Tier 10 SCALE - Caching Caffeine 1000 max 600s expire Stats Redis ready + Security Headers nosniff DENY XSS + Builder Pattern Video.Builder Fluent API + Strategy Pattern Range vs Full 206 + Repository + Caching Pattern + JUnit5 Mockito 6 tests Green Bar Runs: 6/6 Errors: 0 Failures: 0 + viewCount + idx_title + CONTRIBUTING.md 12466 chars + Issues bug_report + feature_request + 16 Badges + Architecture Diagram + Live Link + Docker Multi-Stage + Render Live 2m32s - Roadmap 100% Compliant.

---

# ✨ Features

- Scale Ready status API with JSON response - `{"project":"96-video-streaming-api","status":"Live - Video Streaming API - Tier 10 Scale","tier":"10 - System Design Level - Caching + Security + Testing + Design Patterns","caching":"Caffeine Cache - videos cache - 1000 max, 600s expire - Redis ready","security":"X-Content-Type-Options nosniff, X-Frame-Options DENY, XSS Protection","designPatterns":["Builder Pattern - Video.Builder","Strategy Pattern - Range vs Full Streaming","Repository Pattern","Caching Pattern"],"testing":"JUnit 5 + Mockito - 6 tests"}`
- Fully production Video Streaming API service - 5 endpoints + home + health + upload + list + stream + search - Live on Render Docker - Deploy succeeded 2m32s
- Caching - System Design core - `CacheConfig.java @Configuration @EnableCaching` + `CaffeineCacheManager` + `Caffeine.newBuilder().maximumSize(1000).expireAfterAccess(600, TimeUnit.SECONDS).recordStats().build()` + `@Cacheable("videos") + @Cacheable(value="video", key="#id")` + `@CacheEvict(value="videos", allEntries=true)` on upload + Headers `X-Cache: Caffeine - videos` + `Cache-Control: public max-age=3600` + `spring.cache.type=caffeine` + `spring.cache.caffeine.spec=maximumSize=1000,expireAfterAccess=600s,recordStats` + Stats enabled + Redis pattern ready (Replace CaffeineCacheManager with RedisCacheManager for prod) - Interview ready
- Security Headers - `SecurityHeadersConfig.java @Configuration implements WebMvcConfigurer` + `addInterceptors Interceptor` + `X-Content-Type-Options: nosniff` + `X-Frame-Options: DENY` + `X-XSS-Protection: 1; mode=block` + `Cache-Control` + Validation `@NotBlank` title + File empty check + Content-type validation + File size check - Production security
- Builder Pattern - `Video.java` - Inner Builder class - `public static class Builder` + `private Builder()` + `title(String title) fileName(String fileName) contentType(String contentType) fileSize(Long fileSize) filePath(String filePath) uploadedAt(LocalDateTime uploadedAt) build()` + Fluent API + `new Video.Builder().title(title).fileName(fileName).contentType(contentType).fileSize(fileSize).filePath(filePath).uploadedAt(LocalDateTime.now()).build()` - No telescoping constructor - Production design pattern
- Strategy Pattern - `VideoController.stream()` - Range vs Full Strategy - `if Range header present Range: bytes=0-1023 -> Range-Strategy-206 -> 206 Partial Content + Content-Range: bytes 0-1023/71909571 + Accept-Ranges: bytes + X-Streaming-Strategy: Range-Strategy-206 + 1.45KB chunk else Full-Strategy-200 -> 200 OK + Full file 71MB` - Core YouTube/Netflix Streaming System Design - Interview ready - Range Requests
- Repository Pattern - `VideoRepository.java extends JpaRepository<Video, Long>` + `List<Video> findAllByOrderByUploadedAtDesc()` + `Optional<Video> findByTitle(String title)` + `List<Video> findByTitleContainingIgnoreCase(String keyword)` + Search + `idx_title` index + `viewCount` field - Production pattern
- Caching Pattern - `CacheConfig.java + @Cacheable + @CacheEvict` - Cache-aside pattern - Stats enabled - Redis ready - `videos cache evicted` on upload - `X-Cache: Caffeine` header - Cache hit/miss
- Video Entity - `Video Entity id Long auto increment + title varchar not null + fileName varchar not null + filePath varchar + fileSize bigint + contentType varchar + uploadedAt LocalDateTime + viewCount integer + Builder inner class` - H2 videodb - Video metadata saved
- Upload Logic - `VideoService.uploadVideo(title, file) -> file empty check -> Builder Pattern -> fileName + fileSize + contentType + filePath uploads/ + timestamp now + repository.save() + CacheEvict + Return Video` - Production upload
- Stream Logic - `streamVideo(id, rangeHeader) -> findById -> viewCount++ -> save -> File exists check -> If Range header -> Parse bytes=0-1023 -> Calculate start end -> 206 Partial Content + Content-Range + Accept-Ranges + X-Streaming-Strategy + InputStream skip + byte[] chunk else Full file` - Real streaming
- H2 Database - `jdbc:h2:mem:videodb (FIXED from dbc typo) + ddl-auto=update + video table id bigint file_name file_path file_size title content_type uploaded_at view_count + index idx_title on video (title) + H2Console enabled` - In-memory video testing - Replace with Postgres in prod
- Search - `findByTitleContainingIgnoreCase keyword` + `GET /api/videos/search?keyword=Test` - Elasticsearch pattern ready - For Project 97 Search with Elastic
- JUnit 5 + Mockito Tests - `VideoServiceTest` - `testBuilderPattern()` + `testVideoEntity()` + `testFormatVideo()` + `testGetVideoById_Mockito()` + `testGetAllVideos_Mockito()` + `testSearchVideos_Mockito()` - 6/6 green bar - 0 errors 0 failures - Tier 10 GitHub Goal JUnit + Mockito - Was 2/2 Tier 5 -> Now 6/6 Tier 10 - Console `Mockito Test Passed: getAllVideos - Mocked 2 videos - Caching: videos` + `Builder Pattern Test Passed: Builder Video - builder.mp4` + `Video Entity Test Passed: Test Video - test.mp4 - 1024 bytes` + `Format Video Test Passed: [2026-11-01T15:15:46.640945500] Test Video - test.mp4 (1024 bytes) Views:0` + `Search Test Passed: Found 1 video for keyword Test - Caching + Search` + `Mockito Test Passed: getVideoById - Mocked Repo - Found: Test Video`
- Docker Multi-Stage - `maven:3.9-eclipse-temurin-17 AS build + eclipse-temurin:17-jdk-alpine` + Build inside Docker + `mkdir -p uploads` + COPY --from=build - Fix for Render COPY error + openjdk not found error + uploads not found - Deploy succeeded Live 2m32s - Same as 94 + 95
- Render Live - `https://nine6-video-streaming-api.onrender.com` - Tomcat started on port 10000 - Started Application in 89.599s - Your service is live - Available at primary URL - Docker Free Tier - Deploy succeeded 2m32s - Same as 94/95 Live 2m32s
- CONTRIBUTING.md - Added as per Tier 10 GitHub Goal - 12,466 chars - Open source ready - Includes Caching, Security, Design Patterns, Testing, Video Streaming System Design, Issues, Release Tags, Live
- Issues - `.github/ISSUE_TEMPLATE/bug_report.md + feature_request.md` - Labels bug, enhancement, Tier 10, System Design - GitHub Goal
- Architecture Diagram - Caching + Security + Design Patterns + Range 206 + Docker + Render flow in README - Same as Tier 8 architecture diagram
- One-Command Deploy - Same `mvn spring-boot:run` pattern as Project 95
- Spring Boot banner v3.2.5 inside logs
- Tomcat initialized with port 8098 local, 10000 on Render - Tier 10 Port 8098 - Fourth port in Tier 10
- Started Application in 13.014 seconds (Local Eclipse Java 17) - Includes Caching + Security + Builder + Strategy + JPA - 89.599s on Render Docker (includes Maven build)
- Verified with Browser - `GET / -> Live JSON Tier 10 Caching Security Design Patterns Testing` + `POST /api/videos/upload -> 200 OK id 1 Builder Pattern Cache Evicted` + `GET /api/videos -> [{"id":1,"title":"Test Video",... viewCount:0}] + X-Cache header` + `GET /api/videos/1/stream + Range: bytes=0-1023 -> 206 Partial Content + Content-Range + X-Streaming-Strategy` + `GET /health -> UP Active Caffeine Headers Active Streaming Active` - JUnit green bar 6/6 - Render Live
- Public Production Ready - Portfolio ready Video Streaming API project - Tier 10 SCALE 96/102 - 94% - Only 6 left to 100% - High Pay Package

---

# 🛠 Technologies Used

- Java 17 (21 compatible - eclipse-temurin:17-jdk-alpine)
- Spring Boot 3.2.5 (Banner v3.2.5)
- Spring Web - REST API `@RestController` + `@RequestMapping` + `@GetMapping` + `@PostMapping` + `@PathVariable` + `@RequestParam` + `@RequestHeader` + `ResponseEntity` + `HttpHeaders` + `HttpStatus`
- Spring Cache - `spring-boot-starter-cache` + `Caffeine Cache` + `com.github.ben-manes.caffeine:caffeine` + `@EnableCaching` + `CaffeineCacheManager` + `maximumSize=1000 expireAfterAccess=600s recordStats()` + `@Cacheable("videos")` + `@Cacheable(value="video", key="#id")` + `@CacheEvict(value="videos", allEntries=true)` + `X-Cache` + `Cache-Control` + Redis pattern ready
- Security Headers - `SecurityHeadersConfig.java @Configuration implements WebMvcConfigurer` + `HandlerInterceptor` + `X-Content-Type-Options: nosniff` + `X-Frame-Options: DENY` + `X-XSS-Protection: 1; mode=block` + `Cache-Control: public max-age=3600` + Validation `@NotBlank` + File empty check + Content-type validation - Tier 10 Security
- Design Patterns - Builder Pattern `Video.Builder title() fileName() contentType() fileSize() filePath() uploadedAt() build()` Fluent API + Strategy Pattern `Range: bytes=0-1023 -> 206 Partial Content + Content-Range + X-Streaming-Strategy: Range-Strategy-206 Else 200 OK + Full-Strategy-200` YouTube/Netflix core + Repository Pattern `JpaRepository<Video, Long> + findAllByOrderByUploadedAtDesc + findByTitleContainingIgnoreCase` + Caching Pattern `CacheConfig + @Cacheable + @CacheEvict Cache-aside`
- Spring Data JPA - `@Entity @Table(name="video")` + `JpaRepository<Video, Long>` + `findAllByOrderByUploadedAtDesc()` + `findByTitleContainingIgnoreCase(String keyword)` + `idx_title` index + `view_count`
- H2 Database - `jdbc:h2:mem:videodb (FIXED from dbc:h2:mem:videodb typo missing j - URL must start with 'jdbc' error)` + `H2Console enabled /h2-console` + In-memory for video metadata + `view_count` + `idx_title` - Replace with Postgres in prod
- JUnit 5 + Mockito - `spring-boot-starter-test` - `@ExtendWith(MockitoExtension.class)` + `@Mock VideoRepository` + `@InjectMocks VideoService` + `@BeforeEach` + `when().thenReturn()` + `verify() times()` + `ByteBuddy agent` - 6 tests green - `testBuilderPattern` + `testVideoEntity` + `testFormatVideo` + `testGetVideoById_Mockito` + `testGetAllVideos_Mockito` + `testSearchVideos_Mockito` - Was 2/2 Tier 5 -> Now 6/6 Tier 10 - Tier 10 Tool
- Docker Multi-Stage - `FROM maven:3.9-eclipse-temurin-17 AS build + RUN mvn clean package -DskipTests + FROM eclipse-temurin:17-jdk-alpine + mkdir -p uploads + COPY --from=build /app/target/*.jar app.jar` - Fix for Render COPY error + openjdk not found + uploads not found - Deploy succeeded Live 2m32s - Same as 94 + 95
- Render - Web Service Docker Free Tier - Auto-Deploy on push - Tomcat 10000 - Live https://nine6-video-streaming-api.onrender.com - Deploy succeeded Live 2m32s - Your service is live
- Maven 3.9+
- Apache Tomcat 10.1.20 (Embedded) - TomcatWebServer port 8098 local, 10000 Render
- Postman - For `POST /api/videos/upload 200 OK Builder Pattern Cache Evicted` + `GET /api/videos + X-Cache` + `GET /api/videos/1/stream + Range: bytes=0-1023 -> 206 Partial Content + Content-Range + X-Streaming-Strategy` + `GET /api/videos/search`
- Browser - Chrome - For home + health + list test
- Windows 11 - Eclipse IDE + Browser + Postman
- GitHub - Issues + Release v1.0.0 + CONTRIBUTING.md 12466 chars + 16 Badges + Architecture Diagram + Live Link + Deployed Link - Tier 10 GitHub Goal

---

# 📂 Project Structure - Video Streaming API Repo

```text
96-video-streaming-api
│
├── .github
│   └── ISSUE_TEMPLATE
│       ├── bug_report.md (Labels bug, Tier 10, System Design - Bug Report Template)
│       └── feature_request.md (Labels enhancement, Tier 10 - Feature Request Template)
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── videostreaming
│   │   │           ├── VideoStreamingApplication.java (Main + Tomcat 8098 local 10000 Render + Started 13.014s local 89.599s Render)
│   │   │           ├── config
│   │   │           │   ├── CacheConfig.java (@Configuration @EnableCaching + CaffeineCacheManager maximumSize=1000 expireAfterAccess=600s recordStats() + spring.cache.type=caffeine + spec=maximumSize=1000,expireAfterAccess=600s,recordStats + Redis pattern ready)
│   │   │           │   └── SecurityHeadersConfig.java (@Configuration implements WebMvcConfigurer + HandlerInterceptor + X-Content-Type-Options nosniff + X-Frame-Options DENY + X-XSS-Protection 1; mode=block + Validation - Tier 10 Security)
│   │   │           ├── controller
│   │   │           │   └── VideoController.java (5 endpoints + Home Live JSON Tier 10 Caching Security Design Patterns Testing + Health UP cache Active security Headers Active streaming Active + Upload POST form-data title + file 71MB + List GET @Cacheable videos X-Cache + Stream GET Range bytes=0-1023 -> 206 Partial Content + Content-Range + Accept-Ranges + X-Streaming-Strategy Range-Strategy-206 Else 200 OK Full-Strategy-200 + Search GET keyword Elasticsearch pattern ready - Strategy Pattern core)
│   │   │           ├── model
│   │   │           │   └── Video.java (Entity @Table name=video + id Long auto increment + title varchar not null + fileName varchar not null + filePath varchar + fileSize bigint + contentType varchar + uploadedAt LocalDateTime + viewCount integer + Inner Builder class title() fileName() contentType() fileSize() filePath() uploadedAt() build() Fluent API - Builder Pattern - No Lombok)
│   │   │           ├── repository
│   │   │           │   └── VideoRepository.java (JpaRepository<Video, Long> + List findAllByOrderByUploadedAtDesc + Optional findByTitle + List findByTitleContainingIgnoreCase + Search + idx_title index - Repository Pattern)
│   │   │           └── service
│   │   │               └── VideoService.java (Builder Pattern upload + file empty check + Video.Builder title fileName contentType fileSize filePath uploadedAt build + repository.save + CacheEvict videos cache evicted + viewCount increment + idx_title + Cacheable videos + Cacheable video + formatMessage date title fileName fileSize Views - Production logic)
│   │   │
│   │   └── resources
│   │       └── application.properties (server.port=${PORT:8098} + datasource jdbc:h2:mem:videodb FIXED from dbc typo + jpa ddl-auto update show-sql true + h2 console enabled + cache type caffeine + caffeine spec maximumSize=1000,expireAfterAccess=600s,recordStats + app name 96-video-streaming-api)
│   │
│   └── test
│       └── java
│           └── com
│               └── videostreaming
│                   └── VideoServiceTest.java (JUnit 5 + Mockito - @ExtendWith MockitoExtension + @Mock VideoRepository + @InjectMocks VideoService + @BeforeEach Builder + when().thenReturn() + verify() times() + 6 tests green - testBuilderPattern Builder Video builder.mp4 + testVideoEntity Test Video test.mp4 1024 bytes + testFormatVideo [2026-11-01T15:15:46.640945500] Test Video + testGetVideoById_Mockito Mocked Repo Found Test Video + testGetAllVideos_Mockito Mocked 2 videos Caching videos + testSearchVideos_Mockito Found 1 video for keyword Test Caching + Search - Runs 6/6 Errors 0 Failures 0 Green Bar 3.543s)
│
├── screenshots
│   ├── demo1.png (GET / - Home Live JSON - Video Streaming API Tier 10 - owner Raviteja + security nosniff DENY XSS + designPatterns Builder Strategy Repository Caching + tier 10 System Design Level + port 8098 + testing JUnit5 Mockito 6 tests + project 96-video-streaming-api + caching Caffeine 1000 max 600s expire Redis ready + live https://nine6-video-streaming-api.onrender.com + status Live)
│   ├── demo2.png (GET /health - UP - {"streaming":"Active - Range Requests 206 Partial Content - Strategy Pattern","cache":"Active - Caffeine - videos, video - Stats enabled","security":"Headers Active","project":"96-video-streaming-api","githubGoal":"CONTRIBUTING.md + Issues + Release Tags + Badges + Live Link + Architecture Diagram - Tier 10 Goal","status":"UP"})
│   ├── demo3.png (GET /api/videos - [] - Empty list before upload - Caching videos cache - Initial state)
│   ├── demo4.png (POST /api/videos/upload - Body title Test Video file Screen Recording 2026-08-22 173431.mp4 - 200 OK Time 2.43s Size 656B - Returns id 1 fileName streamUrl cache videos cache evicted fileSize 71909571 uploadedAt message Uploaded - Range Ready - Cache Evicted - Builder Pattern contentType video/mp4 - Builder Pattern + CacheEvict)
│   ├── demo5.png (GET /api/videos - [{"id":1,"title":"Test Video","fileName":"Screen Recording 2026-08-22 173431.mp4","contentType":"video/mp4","fileSize":71909571,"filePath":"uploads\\...","uploadedAt":"2026-11-01T15:10:34.557725","viewCount":0}] - List with viewCount + uploadedAt + filePath - X-Cache Caffeine header + Cache-Control)
│   ├── demo6.png (GET /api/videos/1/stream - Headers Tab Range: bytes=0-1023 + 8 hidden headers - Strategy Pattern Range request setup - Preparing for 206 Partial Content - Postman)
│   ├── demo7.png (GET /api/videos/1/stream - Headers Range bytes=0-1023 Content-Range bytes 0-1023/71909571 Accept-Ranges bytes + X-Streaming-Strategy: Range-Strategy-206 X-Streaming-Strategy Range-Strategy-206 -> Status 206 Partial Content Time 2.47s Size 1.45KB - Body video player 0:00 - Core Tier 10 Feature - YouTube/Netflix Streaming System Design - Strategy Pattern)
│   ├── demo8.png (Eclipse Console - JUnit Console Logs - WARNING A Java agent has been loaded dynamically ByteBuddy - WARNING If a serviceability tool is in use - WARNING If a serviceability tool is not in use - WARNING Dynamic loading of agents will be disallowed - OpenJDK 64-Bit Server VM warning - Mockito Test Passed: getAllVideos - Mocked 2 videos - Caching: videos + Builder Pattern Test Passed: Builder Video - builder.mp4 + Video Entity Test Passed: Test Video - test.mp4 - 1024 bytes + Format Video Test Passed: [2026-11-01T15:15:46.640945500] Test Video - test.mp4 (1024 bytes) Views:0 + Search Test Passed: Found 1 video for keyword Test - Caching + Search + Mockito Test Passed: getVideoById - Mocked Repo - Found: Test Video - Tier 10 Logs)
│   ├── demo9.png (Eclipse JUnit - Finished after 3.543 seconds - Runs: 6/6 Errors: 0 Failures: 0 Green Bar - VideoServiceTest [Runner: JUnit 5] (3.148 s) - Failure Trace empty - Proof of Tier 10 Testing Goal - JUnit + Mockito - Was 2/2 Tier 5 -> Now 6/6 Tier 10)
│   └── demo10.png (GET localhost:8098/api/videos - Raw JSON [{"id":1,"title":"Test Video","fileName":"Screen Recording 2026-08-22 173431.mp4","contentType":"video/mp4","fileSize":71909571,"filePath":"uploads\\...","uploadedAt":"2026-11-01T15:10:34.557725","viewCount":0}] - List after upload - viewCount + uploadedAt + filePath - Full JSON)
│
├── .gitignore (target/ .mvn/ settings/ .classpath .project .factorypath META-INF/ uploads/ *.mp4 *.avi *.mov)
├── CONTRIBUTING.md (Tier 10 GitHub Goal - 12466 chars - Caching, Security, Design Patterns, Testing, Video Streaming System Design, Issues, Release Tags, Live)
├── Dockerfile (Multi-Stage maven:3.9-eclipse-temurin-17 AS build + eclipse-temurin:17-jdk-alpine + mkdir -p uploads + COPY --from=build /app/target/*.jar app.jar - Fix for openjdk not found + COPY target error + uploads not found - Same as 94 + 95)
├── mvnw
├── mvnw.cmd
├── pom.xml (No Lombok - H2 + JPA + Validation + Cache + Caffeine + spring-boot-starter-cache + com.github.ben-manes.caffeine + spring-boot-starter-test + JUnit5 + Mockito + ByteBuddy - Java 17 + Spring Boot 3.2.5)
└── README.md
```

---

# 📸 Screenshots - 10 Demos - Video Streaming API Verified - Live Tier 10

### Demo 1 – Browser - GET / - Home Live JSON - Video Streaming API Tier 10 SCALE
[Demo1 Home](screenshots/demo1.png)

*GET http://localhost:8098/ - Browser - 200 OK - Returns {"owner":"Raviteja","security":"X-Content-Type-Options nosniff, X-Frame-Options DENY, XSS Protection","designPatterns":["Builder Pattern - Video.Builder","Strategy Pattern - Range vs Full Streaming","Repository Pattern","Caching Pattern"],"tier":"10 - System Design Level - Caching + Security + Testing + Design Patterns","port":"8098","testing":"JUnit 5 + Mockito - 6 tests - Builder + Service + Controller Mock","project":"96-video-streaming-api","caching":"Caffeine Cache - videos cache - 1000 max, 600s expire - Redis ready","live":"https://nine6-video-streaming-api.onrender.com","status":"Live - Video Streaming API - Tier 10 Scale"} - Proof of Home Live - Portfolio ready - Tier 10 SCALE 96/102 - 94% - Caching + Security + Design Patterns + Testing - Same as 95 but 96 Video Streaming*

### Demo 2 – Browser - GET /health - UP - Caching + Security + Streaming Active
[Demo2 Health](screenshots/demo2.png)

*GET http://localhost:8098/health - Browser - 200 OK - Returns {"streaming":"Active - Range Requests 206 Partial Content - Strategy Pattern","cache":"Active - Caffeine - videos, video - Stats enabled","security":"Headers Active","project":"96-video-streaming-api","githubGoal":"CONTRIBUTING.md + Issues + Release Tags + Badges + Live Link + Architecture Diagram - Tier 10 Goal","status":"UP"} - Proof of Health Endpoint - Tier 10 Health Check - Caching Active Caffeine Stats enabled - Security Headers Active - Streaming Active Range Requests 206 Strategy Pattern - GitHub Goal CONTRIBUTING.md Issues Release Tags - Same as Project 95 health but with cache + security + streaming*

### Demo 3 – Browser - GET /api/videos - Empty List - Before Upload - Caching Ready
[Demo3 Empty List](screenshots/demo3.png)

*GET http://localhost:8098/api/videos - Browser - 200 OK - Returns [] - Empty JSON array - Proof of List Endpoint Working - No videos yet - H2 in-memory empty - Caching videos cache ready - X-Cache: Caffeine - videos header ready - Real video app starts empty like YouTube before upload*

### Demo 4 – Postman - POST /api/videos/upload - 200 OK - id 1 - Builder Pattern + Cache Evicted
[Demo4 Upload Builder](screenshots/demo4.png)

*POST http://localhost:8098/api/videos/upload - Body form-data title Test Video file Screen Recording 2026-08-22 173431.mp4 (71MB) - Postman - 200 OK Time 2.43s Size 656B - Returns {"streamUrl":"http://localhost:8098/api/videos/1/stream","fileName":"Screen Recording 2026-08-22 173431.mp4","cache":"videos cache evicted","fileSize":71909571,"uploadedAt":"2026-11-01T15:10:34.557725","id":1,"title":"Test Video","message":"Uploaded - Range Ready - Cache Evicted - Builder Pattern","contentType":"video/mp4"} - Proof of Upload Endpoint Working - Builder Pattern Video.Builder title fileName contentType fileSize filePath uploadedAt build Fluent API - CacheEvict allEntries true - videos cache evicted - File saved to uploads/ + filePath uploads\1793526034325_Screen Recording - 71MB - Live on Render URL pattern - Same as 95 but Builder Pattern*

### Demo 5 – Browser - GET /api/videos - With Video - viewCount + X-Cache
[Demo5 List viewCount](screenshots/demo5.png)

*GET http://localhost:8098/api/videos - Browser - 200 OK Time 2.03s Size 656B - Returns [{"id":1,"title":"Test Video","fileName":"Screen Recording 2026-08-22 173431.mp4","contentType":"video/mp4","fileSize":71909571,"filePath":"uploads\\1793526034325_Screen Recording 2026-08-22 173431.mp4","uploadedAt":"2026-11-01T15:10:34.557725","viewCount":0}] - Proof of List Persistence - Video saved in H2 - viewCount 0 + uploadedAt + filePath + idx_title index + findAllByOrderByUploadedAtDesc working - Caching videos cache - X-Cache: Caffeine header + Cache-Control public max-age=3600 - Same as 95 history after but with viewCount + filePath*

### Demo 6 – Postman - GET /api/videos/1/stream - Range Header - Strategy Pattern Request
[Demo6 Stream Request](screenshots/demo6.png)

*GET http://localhost:8098/api/videos/1/stream - Headers Tab Key Range Value bytes=0-1023 + 8 hidden headers - Postman - Preparing for 206 Partial Content - Strategy Pattern Range-Strategy-206 request - Range: bytes=0-1023 - Postman Headers (9) tab - Proof of Range Request Setup - System Design core - YouTube/Netflix streaming - Real streaming starts with Range header*

### Demo 7 – Postman - GET /api/videos/1/stream - 206 Partial Content - Strategy Pattern Response - Tier 10 Core
[Demo7 Stream 206](screenshots/demo7.png)

*GET http://localhost:8098/api/videos/1/stream - Headers Range bytes=0-1023 Content-Range bytes 0-1023/71909571 Accept-Ranges bytes + X-Streaming-Strategy: Range-Strategy-206 X-Streaming-Strategy Range-Strategy-206 - Postman - Status 206 Partial Content Time 2.47s Size 1.45KB - Body video player black screen 0:00 - Proof of Stream Endpoint Working - Strategy Pattern Range-Strategy-206 vs Full-Strategy-200 - 206 Partial Content + Content-Range: bytes start-end/fileSize + Accept-Ranges: bytes + X-Streaming-Strategy header - Real YouTube/Netflix streaming chunk 1.45KB from 71MB file - Core Tier 10 Feature - System Design Interview Ready - Same as 95 WebSocket but for video streaming*

### Demo 8 – Eclipse Console - JUnit Console Logs - Builder + Mockito + Search
[Demo8 JUnit Console](screenshots/demo8.png)

*Eclipse Console - <terminated> VideoServiceTest [JUnit] - WARNING A Java agent has been loaded dynamically C:\Users\Ravi Teja\.m2\repository\net\bytebuddy\byte-buddy-agent\1.14.13\byte-buddy-agent-1.14.13.jar - WARNING If a serviceability tool is in use, please run with -XX:+EnableDynamicAgentLoading to hide this warning - WARNING If a serviceability tool is not in use, please run with -Djdk.instrument.traceUsage for more information - WARNING Dynamic loading of agents will be disallowed by default in a future release - OpenJDK 64-Bit Server VM warning: Sharing is only supported for boot loader classes because bootstrap classpath has been appended - Mockito Test Passed: getAllVideos - Mocked 2 videos - Caching: videos + Builder Pattern Test Passed: Builder Video - builder.mp4 + Video Entity Test Passed: Test Video - test.mp4 - 1024 bytes + Format Video Test Passed: [2026-11-01T15:15:46.640945500] Test Video - test.mp4 (1024 bytes) Views:0 + Search Test Passed: Found 1 video for keyword Test - Caching + Search + Mockito Test Passed: getVideoById - Mocked Repo - Found: Test Video - Proof of Test Output - Builder Pattern + Mockito Mock Repo + when().thenReturn() + verify() + Caching + Search - Console logs same as Project 95 ChatServiceTest but 6 tests - Tier 10 SCALE*

### Demo 9 – Eclipse JUnit - Green Bar - 6/6 Tests Passed - VideoServiceTest - Tier 10 Testing PASS
[Demo9 JUnit Green](screenshots/demo9.png)

*Eclipse JUnit - Finished after 3.543 seconds - Runs: 6/6 Errors: 0 Failures: 0 Green Bar - VideoServiceTest [Runner: JUnit 5] (3.148 s) - Failure Trace empty - Proof of Tier 10 Testing Goal - JUnit + Mockito - Was 2/2 Tier 5 -> Now 6/6 Tier 10 - Builder Pattern + Entity + Format + Mockito Mock Repo getById + getAll + Search - Same as Project 95 Green Bar but 6/6 not 2/2 - Tier 10 SCALE*

### Demo 10 – Browser - GET /api/videos - Raw JSON - viewCount + Full List
[Demo10 Raw JSON](screenshots/demo10.png)

*Browser - GET http://localhost:8098/api/videos - 200 OK - Raw JSON [{"id":1,"title":"Test Video","fileName":"Screen Recording 2026-08-22 173431.mp4","contentType":"video/mp4","fileSize":71909571,"filePath":"uploads\\1793526034325_Screen Recording 2026-08-22 173431.mp4","uploadedAt":"2026-11-01T15:10:34.557725","viewCount":0}] - Proof of Raw List - viewCount + uploadedAt + filePath + fileSize + contentType + title + id - H2 videodb + view_count + idx_title - Full JSON without pretty print - Same as 95 history after but with filePath + viewCount*

---

# ▶ How to Run - Video Streaming API Repo

## 1⃣ Clone the Repository

```bash
git clone https://github.com/raviteja-dev950/96-video-streaming-api.git
cd 96-video-streaming-api
```

---

## 2⃣ Verify application.properties & Controllers

- Verify `src/main/resources/application.properties` - No Lombok - Caching + Security + Video Streaming

```properties
server.port=${PORT:8098}
spring.datasource.url=jdbc:h2:mem:videodb
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.cache.type=caffeine
spring.cache.caffeine.spec=maximumSize=1000,expireAfterAccess=600s,recordStats
spring.application.name=96-video-streaming-api
```

## 3⃣ Run in Eclipse IDE (No Docker Needed) - Fresh Start

```text
File -> New -> Spring Starter Project
  Name: 96-video-streaming-api
  Group: com.videostreaming
  Artifact: 96-video-streaming-api
  Package: com.videostreaming
  Java: 17
  Dependencies: H2, Spring Data JPA, Spring Web, Validation, Cache, Caffeine
Finish

Replace src + pom.xml from this repo
Delete META-INF folder if exists (Eclipse bug - Same as 93/94/95)
Project -> Clean -> Clean all
Right Click Project -> Maven -> Update Project -> Force Update -> OK
If Cache error: Right Click Project -> Maven -> Update Project -> Check Force Update of Snapshots/Releases -> OK - Caffeine dependencies download
Right Click Project -> Run As -> Maven clean -> Maven install
Right Click Project -> Run As -> Spring Boot App -> Or java -jar target/*.jar
```

Expected Console:
```text
 :: Spring Boot ::                (v3.2.5)
 Tomcat initialized with port 8098 (http)
 HikariPool-1 - Starting... HikariPool-1 - Start completed
 HikariPool-1 - Added connection conn0: url=jdbc:h2:mem:videodb user=SA
 Hibernate: create table video (id bigint not null, content_type varchar(255), file_name varchar(255), file_path varchar(255), file_size bigint not null, title varchar(255), uploaded_at timestamp(6), view_count integer not null, primary key (id))
 Hibernate: create index idx_title on video (title)
 Tomcat started on port 8098 (http) with context path ''
 Started VideoStreamingApplication in 13.014 seconds (process running for 15.708) - Includes Caching + Security + Builder + Strategy + JPA
```

## 4⃣ Test with Browser + Postman - 5 Endpoints + Range 206

- GET http://localhost:8098/ -> Live JSON Tier 10 SCALE + Caching Caffeine + Security nosniff DENY XSS + Design Patterns Builder Strategy Repository Caching + Testing JUnit5 Mockito 6 tests + Live https://nine6-video-streaming-api.onrender.com
- GET http://localhost:8098/health -> UP + cache Active Caffeine Stats enabled + security Headers Active + streaming Active Range Requests 206 Partial Content Strategy Pattern + githubGoal CONTRIBUTING.md Issues Release Tags
- GET http://localhost:8098/api/videos -> [] empty before upload + X-Cache: Caffeine - videos + Cache-Control public max-age=3600
- POST http://localhost:8098/api/videos/upload Body form-data title Test Video file Screen Recording 2026-08-22 173431.mp4 (71MB) -> 200 OK id 1 fileName streamUrl cache videos cache evicted fileSize 71909571 uploadedAt message Uploaded - Range Ready - Cache Evicted - Builder Pattern contentType video/mp4 - Builder Pattern + CacheEvict
- GET http://localhost:8098/api/videos -> [{"id":1,"title":"Test Video","fileName":"...","contentType":"video/mp4","fileSize":71909571,"filePath":"uploads\\...","uploadedAt":"2026-11-01T15:10:34.557725","viewCount":0}] - viewCount + idx_title + X-Cache
- GET http://localhost:8098/api/videos/1/stream -> Full file 71MB 200 OK Full-Strategy-200 - No Range header
- GET http://localhost:8098/api/videos/1/stream + Header Range: bytes=0-1023 -> 206 Partial Content + Content-Range: bytes 0-1023/71909571 + Accept-Ranges: bytes + X-Streaming-Strategy: Range-Strategy-206 + 1.45KB chunk - Strategy Pattern Range-Strategy-206 - Core Tier 10 Feature
- GET http://localhost:8098/api/videos/search?keyword=Test -> Search by titleContainingIgnoreCase - Elasticsearch pattern ready - [{"id":1,...}]
- Browser refresh list multiple times -> X-Cache: Caffeine hit - Caching working

## 5⃣ Test JUnit - 6/6 Green Bar - Tier 10

```text
Right Click VideoServiceTest.java -> Run As -> JUnit Test
Expected: Runs 6/6 Errors 0 Failures 0 Green Bar + Console Mockito Test Passed: getAllVideos - Mocked 2 videos - Caching: videos + Builder Pattern Test Passed: Builder Video - builder.mp4 + Video Entity Test Passed: Test Video - test.mp4 - 1024 bytes + Format Video Test Passed: [2026-11-01T15:15:46.640945500] Test Video - test.mp4 (1024 bytes) Views:0 + Search Test Passed: Found 1 video for keyword Test - Caching + Search + Mockito Test Passed: getVideoById - Mocked Repo - Found: Test Video + ByteBuddy warnings + Finished after 3.543 seconds VideoServiceTest [Runner: JUnit 5] (3.148 s) - Was 2/2 Tier 5 -> Now 6/6 Tier 10
```

## 6⃣ Deploy to Render (Live) - TIER 10 SCALE - Docker Multi-Stage

```text
Runtime: Docker (Multi-Stage)
Build: Docker builds maven:3.9-eclipse-temurin-17 AS build -> mvn clean package -DskipTests
Start: java -jar app.jar
Port: 8098 local, 10000 Render (Tomcat auto)
Env: PORT=10000 (Render sets)
Live: https://nine6-video-streaming-api.onrender.com
Deploy succeeded Live - 2m32s - Tomcat started on port 10000 - Started Application in 89.599s - Your service is live - Same as 94 + 95 Live 2m32s
```

Dockerfile:
```dockerfile
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
RUN mkdir -p uploads
COPY --from=build /app/target/*.jar app.jar
EXPOSE 10000
ENTRYPOINT ["java", "-jar", "app.jar"]
```

---

# 🔄 Flow Diagram - How Video Streaming API Works - Tier 10 SCALE

```text
    User Laptop (Eclipse + Browser + Postman)
        |
        +-- E:\Java-100-Projects\96-video-streaming-api
        |       +-- src -> VideoStreamingApplication.java (Main + Tomcat 8098 local 10000 Render + Started 13.014s local 89.599s Render)
        |       +-- config -> CacheConfig.java (@Configuration @EnableCaching + CaffeineCacheManager maximumSize=1000 expireAfterAccess=600s recordStats() + spring.cache.type=caffeine + spec=maximumSize=1000,expireAfterAccess=600s,recordStats + Redis pattern ready)
        |       +-- config -> SecurityHeadersConfig.java (@Configuration implements WebMvcConfigurer + HandlerInterceptor + X-Content-Type-Options nosniff + X-Frame-Options DENY + X-XSS-Protection 1; mode=block + Validation - Tier 10 Security)
        |       +-- model -> Video.java (Entity @Table name=video + id Long auto increment + title varchar not null + fileName varchar not null + filePath varchar + fileSize bigint + contentType varchar + uploadedAt LocalDateTime + viewCount integer + Inner Builder class title() fileName() contentType() fileSize() filePath() uploadedAt() build() Fluent API - Builder Pattern - No Lombok - No telescoping constructor)
        |       +-- repository -> VideoRepository.java (JpaRepository<Video, Long> + List findAllByOrderByUploadedAtDesc + Optional findByTitle + List findByTitleContainingIgnoreCase + Search + idx_title index - Repository Pattern - Elasticsearch pattern ready)
        |       +-- service -> VideoService.java (Builder Pattern upload + file empty check + Video.Builder title fileName contentType fileSize filePath uploadedAt build + repository.save + CacheEvict value=videos allEntries=true videos cache evicted + viewCount increment + idx_title + Cacheable videos + Cacheable video key=id + formatMessage date title fileName fileSize Views - Production logic)
        |       +-- controller -> VideoController.java (5 endpoints + Home Live JSON Tier 10 Caching Security Design Patterns Testing + Health UP cache Active Caffeine Stats enabled security Headers Active streaming Active Range Requests 206 Strategy Pattern + githubGoal CONTRIBUTING.md + Upload POST form-data title file 71MB + List GET @Cacheable videos X-Cache Caffeine + Stream GET Range bytes=0-1023 -> 206 Partial Content + Content-Range bytes start-end/fileSize + Accept-Ranges bytes + X-Streaming-Strategy Range-Strategy-206 Else 200 OK Full-Strategy-200 + Search GET keyword Elasticsearch pattern ready - Strategy Pattern Range vs Full core - YouTube/Netflix)
        |       +-- test -> VideoServiceTest.java (JUnit 5 + Mockito - 6 tests green - testBuilderPattern Builder Video builder.mp4 + testVideoEntity Test Video test.mp4 1024 bytes + testFormatVideo [date] Test Video + testGetVideoById_Mockito Mocked Repo Found Test Video + testGetAllVideos_Mockito Mocked 2 videos Caching videos + testSearchVideos_Mockito Found 1 video for keyword Test Caching + Search - Runs 6/6 Errors 0 Failures 0 Green Bar 3.543s)
        |       +-- resources -> application.properties (server.port=${PORT:8098} + datasource jdbc:h2:mem:videodb FIXED from dbc typo + jpa ddl-auto update show-sql true + h2 console enabled + cache type caffeine + caffeine spec maximumSize=1000,expireAfterAccess=600s,recordStats + app name 96-video-streaming-api)
        |       +-- screenshots (demo1-10)
        |       +-- Dockerfile (Multi-Stage maven:3.9-eclipse-temurin-17 AS build + eclipse-temurin:17-jdk-alpine + mkdir -p uploads + COPY --from=build /app/target/*.jar app.jar - Fix for openjdk not found + COPY target error + uploads not found - Same as 94 + 95)
        |       +-- CONTRIBUTING.md (12466 chars - Tier 10 GitHub Goal - Caching, Security, Design Patterns, Testing, Video Streaming System Design, Issues, Release Tags, Live)
        |       +-- .github/ISSUE_TEMPLATE (bug_report.md + feature_request.md - Labels bug, enhancement, Tier 10, System Design)
        |
        v
    git push origin main
        |
        +---> GitHub Repository: raviteja-dev950/96-video-streaming-api
        |           |
        |           v
        |       Render Auto Deploy (Docker Multi-Stage)
        |           +-- FROM maven:3.9-eclipse-temurin-17 AS build -> COPY pom.xml src -> RUN mvn clean package -DskipTests
        |           +-- FROM eclipse-temurin:17-jdk-alpine -> mkdir -p uploads -> COPY --from=build target/*.jar app.jar
        |           +-- EXPOSE 10000 -> ENTRYPOINT java -jar app.jar
        |           +-- Tomcat initialized with port 10000 - HikariPool-1 - Added connection conn0 url=jdbc:h2:mem:videodb user=SA - create table video + create index idx_title - Tomcat started on port 10000 - Started Application in 89.599s - Your service is live -> https://nine6-video-streaming-api.onrender.com
        |           +-- Deploy succeeded Live 2m32s - Green Tick - Same as 94 + 95 Live 2m32s
        |
        v
    Local Eclipse Run (Caching + Security + Builder + Strategy Pattern)
        |
        +-- Spring Boot App -> Tomcat 8098 local
        |     +-- Caching
        |     |     +-- CacheConfig @Configuration @EnableCaching
        |     |     +-- CaffeineCacheManager -> Caffeine.newBuilder().maximumSize(1000).expireAfterAccess(600, TimeUnit.SECONDS).recordStats().build()
        |     |     +-- @Cacheable("videos") on getAllVideos -> First call DB -> Cache put -> Next calls Cache hit -> X-Cache: Caffeine - videos header + Cache-Control public max-age=3600 - Redis pattern ready
        |     |     +-- @Cacheable(value="video", key="#id") on getVideoById -> Cache by id
        |     |     +-- @CacheEvict(value="videos", allEntries=true) on uploadVideo -> Evict cache on new video upload -> videos cache evicted message - Cache-aside pattern - Caching Pattern
        |     |     +-- Stats enabled - recordStats() - Cache hit/miss stats - Production ready
        |     +-- Security Headers
        |     |     +-- SecurityHeadersConfig @Configuration implements WebMvcConfigurer
        |     |     +-- addInterceptors -> HandlerInterceptor
        |     |           +-- preHandle -> response.setHeader("X-Content-Type-Options", "nosniff") + "X-Frame-Options: DENY" + "X-XSS-Protection: 1; mode=block" + "Cache-Control: public, max-age=3600"
        |     |     +-- Validation -> @NotBlank title + File empty check + Content-type validation + File size check - Tier 10 Security
        |     +-- JPA + H2 + viewCount + idx_title
        |     |     +-- Video Entity id auto increment + title varchar not null + fileName varchar not null + filePath varchar + fileSize bigint + contentType varchar + uploadedAt LocalDateTime + viewCount integer + Builder inner class
        |     |     +-- VideoRepository extends JpaRepository + findAllByOrderByUploadedAtDesc + findByTitleContainingIgnoreCase + idx_title index + viewCount
        |     |     +-- Hibernate create table video + create index idx_title - H2 videodb - jdbc:h2:mem:videodb FIXED from dbc typo - URL must start with jdbc error fixed
        |     +-- Builder Pattern
        |     |     +-- Video.Builder inner static class + private Builder() + title() fileName() contentType() fileSize() filePath() uploadedAt() build() Fluent API
        |     |     +-- new Video.Builder().title(title).fileName(fileName).contentType(contentType).fileSize(fileSize).filePath(filePath).uploadedAt(LocalDateTime.now()).build() - No telescoping constructor - Production design pattern
        |     |     +-- Builder Pattern Test Passed: Builder Video - builder.mp4 - JUnit
        |     +-- Strategy Pattern - Range vs Full Streaming - YouTube/Netflix core
        |     |     +-- VideoController.streamVideo(id, rangeHeader)
        |     |           +-- findById id -> viewCount++ -> save
        |     |           +-- File exists check -> uploads/filePath
        |     |           +-- If rangeHeader present Range: bytes=0-1023 -> Parse start end -> Range-Strategy-206 -> 206 Partial Content + HttpHeaders Content-Range bytes start-end/fileSize + Accept-Ranges bytes + X-Streaming-Strategy Range-Strategy-206 + InputStream skip start + byte[] buffer 1024 chunk + ResponseEntity status 206 + Headers + Body chunk 1.45KB - Real streaming chunk
        |     |           +-- Else Full-Strategy-200 -> 200 OK + Full file 71MB + Content-Type video/mp4 + Content-Length fileSize + X-Streaming-Strategy Full-Strategy-200 - Full streaming
        |     |     +-- Strategy Pattern Test via Postman - Range header bytes=0-1023 -> 206 Partial Content + Content-Range bytes 0-1023/71909571 + Accept-Ranges bytes + X-Streaming-Strategy Range-Strategy-206 - Core Tier 10 Feature
        |     +-- Service Logic
        |     |     +-- uploadVideo(title, file)
        |     |           +-- file empty check -> Throw if empty
        |     |           +-- fileName = file.getOriginalFilename() -> fileSize = file.getSize() -> contentType = file.getContentType()
        |     |           +-- filePath = uploads/ + System.currentTimeMillis() + _ + fileName
        |     |           +-- file.transferTo(new File(filePath)) -> Save to uploads/
        |     |           +-- Builder Pattern -> Video.Builder title fileName contentType fileSize filePath uploadedAt build
        |     |           +-- videoRepository.save(video) -> DB persist + CacheEvict allEntries true -> Return video with id
        |     |     +-- getAllVideos() -> @Cacheable videos -> videoRepository.findAllByOrderByUploadedAtDesc() -> Ordered by uploadedAt DESC + idx_title - Caching Pattern
        |     |     +-- getVideoById(id) -> @Cacheable video key id -> videoRepository.findById(id) -> viewCount++ -> save -> Return video
        |     |     +-- searchVideos(keyword) -> videoRepository.findByTitleContainingIgnoreCase(keyword) -> Elasticsearch pattern ready
        |     |     +-- formatVideo(video) -> "[" + uploadedAt + "] " + title + " - " + fileName + " (" + fileSize + " bytes) Views:" + viewCount - For logs
        |     +-- Controllers
        |           +-- GET / -> Map response project 96-video-streaming-api status Live tier 10 owner Raviteja caching Caffeine Cache videos cache 1000 max 600s expire Redis ready security nosniff DENY XSS designPatterns Builder Strategy Repository Caching testing JUnit5 Mockito 6 tests live https://nine6-... port 8098 status Live - Video Streaming API - Tier 10 Scale
        |           +-- GET /health -> Map project 96 status UP cache Active Caffeine videos video Stats enabled security Headers Active streaming Active Range Requests 206 Partial Content Strategy Pattern githubGoal CONTRIBUTING.md Issues Release Tags Badges Live Link Architecture Diagram Tier 10 Goal - Health check for Render
        |           +-- POST /api/videos/upload @RequestParam title + @RequestParam MultipartFile file -> Check null/empty -> service.uploadVideo(title, file) -> Return 200 OK with Video id title fileName fileSize filePath contentType uploadedAt viewCount 0 streamUrl http://localhost:8098/api/videos/{id}/stream cache videos cache evicted message Uploaded - Range Ready - Cache Evicted - Builder Pattern - Builder Pattern + CacheEvict
        |           +-- GET /api/videos -> service.getAllVideos() -> @Cacheable videos -> Return List<Video> + Headers X-Cache Caffeine - videos + Cache-Control public max-age=3600 - [] if empty - Caching working
        |           +-- GET /api/videos/{id}/stream @PathVariable id + @RequestHeader(value="Range", required=false) rangeHeader -> service.getVideoById(id) viewCount++ + File -> Strategy Pattern Range vs Full -> Return ResponseEntity 206 Partial Content + Content-Range + Accept-Ranges + X-Streaming-Strategy Range-Strategy-206 + Body 1.45KB chunk else 200 OK Full 71MB + X-Streaming-Strategy Full-Strategy-200
        |           +-- GET /api/videos/search @RequestParam keyword -> service.searchVideos(keyword) -> findByTitleContainingIgnoreCase -> Return List<Video> - Search - Elasticsearch pattern ready
        |     +-- JUnit + Mockito
        |           +-- VideoServiceTest @ExtendWith(MockitoExtension.class)
        |                 +-- @Mock VideoRepository + @InjectMocks VideoService + @BeforeEach Builder Pattern setup
        |                 +-- testBuilderPattern() -> Video.Builder title Builder Video fileName builder.mp4 contentType video/mp4 fileSize 1024 filePath uploads/builder.mp4 uploadedAt now build -> assertNotNull + assertEquals title Builder Video + fileName builder.mp4 -> System.out Builder Pattern Test Passed: Builder Video - builder.mp4
        |                 +-- testVideoEntity() -> new Video title Test Video fileName test.mp4 fileSize 1024 contentType video/mp4 -> assertEquals Test Video title + test.mp4 fileName + 1024 fileSize -> System.out Video Entity Test Passed: Test Video - test.mp4 - 1024 bytes
        |                 +-- testFormatVideo() -> Video Test Video test.mp4 1024 bytes Views 0 + uploadedAt now -> service.formatVideo(video) -> assertTrue contains Test Video + test.mp4 -> System.out Format Video Test Passed: [2026-11-01T15:15:46.640945500] Test Video - test.mp4 (1024 bytes) Views:0
        |                 +-- testGetVideoById_Mockito() -> Video id 1 title Test Video + Mock repo when(videoRepository.findById(1L)).thenReturn(Optional.of(video)) -> service.getVideoById(1L) -> assertEquals Test Video + verify(videoRepository, times(1)).findById(1L) -> System.out Mockito Test Passed: getVideoById - Mocked Repo - Found: Test Video - when().thenReturn() + verify()
        |                 +-- testGetAllVideos_Mockito() -> Video1 + Video2 + Mock repo when(videoRepository.findAllByOrderByUploadedAtDesc()).thenReturn(Arrays.asList(video1, video2)) -> service.getAllVideos() -> assertEquals 2 size + verify -> System.out Mockito Test Passed: getAllVideos - Mocked 2 videos - Caching: videos - Caching Pattern
        |                 +-- testSearchVideos_Mockito() -> Video Test Video + Mock repo when(videoRepository.findByTitleContainingIgnoreCase("Test")).thenReturn(Arrays.asList(video)) -> service.searchVideos("Test") -> assertEquals 1 size + Test Video title -> System.out Search Test Passed: Found 1 video for keyword Test - Caching + Search - Elasticsearch pattern ready
        |                 +-- Green Bar 6/6 - Runs: 6/6 Errors: 0 Failures: 0 - Finished after 3.543 seconds - VideoServiceTest [Runner: JUnit 5] (3.148 s) - Tier 10 Testing - Was 2/2 Tier 5 -> Now 6/6 Tier 10
        |
        v
    Browser / Portfolio
        |
        +-- localhost:8098/ -> Live JSON Tier 10 SCALE + Caching + Security + Design Patterns + Testing - Home Verified Demo1
        +-- localhost:8098/health -> UP + cache Active Caffeine Stats enabled + security Headers Active + streaming Active Range Requests 206 Strategy Pattern + githubGoal CONTRIBUTING.md Issues Release Tags - Health Verified Demo2
        +-- localhost:8098/api/videos -> [] empty then [{"id":1,... viewCount:0}] after upload + X-Cache Caffeine - videos + Cache-Control - List Verified Demo3 + Demo5 + Demo10
        +-- localhost:8098/api/videos/upload POST Test Video + Screen Recording 2026-08-22 173431.mp4 71MB -> 200 OK id 1 fileName streamUrl cache videos cache evicted fileSize 71909571 uploadedAt message Uploaded - Range Ready - Cache Evicted - Builder Pattern - Upload Verified Demo4
        +-- localhost:8098/api/videos/1/stream + Header Range: bytes=0-1023 -> 206 Partial Content + Content-Range bytes 0-1023/71909571 + Accept-Ranges bytes + X-Streaming-Strategy Range-Strategy-206 + 1.45KB chunk + video player 0:00 - Stream Verified Demo6 + Demo7 - Strategy Pattern Range-Strategy-206 - Core Tier 10 Feature - YouTube/Netflix Streaming System Design
        +-- localhost:8098/api/videos/search?keyword=Test -> Search by titleContainingIgnoreCase - Elasticsearch pattern ready - Search Verified
        +-- JUnit Green Bar -> 6/6 Passed - Testing Verified - Tier 10 Goal Demo9 + Console logs Builder + Mockito + Search Demo8
        +-- Render Live: https://nine6-video-streaming-api.onrender.com/ -> Deploy succeeded Live 2m32s - Tomcat 10000 - Started 89.599s - Your service is live - Live Verified Demo11+12 (after push)
        +-- Live: https://nine6-video-streaming-api.onrender.com/api/videos -> Same on Internet - List from H2 - viewCount
              |
              v
    Portfolio: Live URL + GitHub + 10 Demo Screenshots + Flow Diagram Caching + Security + Builder + Strategy + JUnit5 Mockito 6/6 Green + CONTRIBUTING.md 12466 chars + Issues + Release Tags v1.0.0 + 16 Badges + Architecture Diagram + Live Link + Deployed Link + Docker Multi-Stage + Render Live 2m32s -> Resume Ready - Tier 10 SCALE 96/102 - 94% - Only 6 left to 100% - High Pay Package - System Design Interview Ready (Caching Caffeine 1000 max 600s Stats Redis ready, Security Headers nosniff DENY XSS, Builder Pattern Fluent API, Strategy Pattern Range 206 vs Full, Repository Pattern, Caching Pattern Cache-aside, JUnit5 Mockito Mock Repo when verify, Range Requests 206 Partial Content Content-Range Accept-Ranges X-Streaming-Strategy, Docker Multi-Stage maven:3.9-eclipse-temurin-17 + eclipse-temurin:17-jdk-alpine + mkdir -p uploads, Render Deploy Live 2m32s)
```

---

# 🧪 API Testing Examples

```bash
# Home - Tier 10 SCALE
curl http://localhost:8098/
curl https://nine6-video-streaming-api.onrender.com/

# Health - UP + cache Active + security Headers Active + streaming Active
curl http://localhost:8098/health
curl https://nine6-video-streaming-api.onrender.com/health

# List - Empty [] before upload + X-Cache header
curl http://localhost:8098/api/videos

# Upload - Builder Pattern + CacheEvict
curl -X POST http://localhost:8098/api/videos/upload -F "title=Test Video" -F "file=@Screen Recording 2026-08-22 173431.mp4"
# Returns 200 OK {id:1, title:Test Video, fileName:Screen Recording..., fileSize:71909571, filePath:uploads\..., uploadedAt:2026-11-01T15:10:34.557725, viewCount:0, streamUrl:http://localhost:8098/api/videos/1/stream, cache:videos cache evicted, message:Uploaded - Range Ready - Cache Evicted - Builder Pattern, contentType:video/mp4}

# List After Upload - viewCount + idx_title + X-Cache
curl http://localhost:8098/api/videos
# Returns [{"id":1,"title":"Test Video","fileName":"Screen Recording 2026-08-22 173431.mp4","contentType":"video/mp4","fileSize":71909571,"filePath":"uploads\\1793526034325_Screen Recording 2026-08-22 173431.mp4","uploadedAt":"2026-11-01T15:10:34.557725","viewCount":0}]

# Stream - Full - 200 OK Full-Strategy-200 - No Range header
curl http://localhost:8098/api/videos/1/stream --output video.mp4

# Stream - Range - 206 Partial Content - Strategy Pattern Range-Strategy-206 - Core Tier 10 Feature - YouTube/Netflix
curl -H "Range: bytes=0-1023" http://localhost:8098/api/videos/1/stream --output chunk.mp4
# Returns 206 Partial Content + Content-Range: bytes 0-1023/71909571 + Accept-Ranges: bytes + X-Streaming-Strategy: Range-Strategy-206 + Body 1.45KB chunk

# Search - Elasticsearch pattern ready - For Project 97
curl http://localhost:8098/api/videos/search?keyword=Test
# Returns [{"id":1,"title":"Test Video",...}] - Search by titleContainingIgnoreCase

# Render Live - Same on Internet
curl https://nine6-video-streaming-api.onrender.com/
curl https://nine6-video-streaming-api.onrender.com/health
curl https://nine6-video-streaming-api.onrender.com/api/videos
curl https://nine6-video-streaming-api.onrender.com/api/videos/search?keyword=Test
```

---

# 👨💻 Author

Ravi Teja

Java Full Stack Developer

102 Java Full Stack Projects Challenge

Project 96 / 102

Tier 10 – System Design Level – SCALE – TIER 10 SCALE 96/102 - 94% - Deploy succeeded Live 2m32s - Fixed dbc typo + META-INF + openjdk not found + COPY target + uploads not found + Tier 5 -> Tier 10 with Caching + Security + Builder + Strategy + JUnit5 Mockito 6/6 Green

---

## ⭐ Support

If you found this project helpful, consider giving it a ⭐ Star on GitHub.

**Single Repo:** [96-video-streaming-api](https://github.com/raviteja-dev950/96-video-streaming-api)

**Live URL:** https://nine6-video-streaming-api.onrender.com/

**Deploy:** Deploy succeeded Live - 2m32s - Tomcat 10000 - Started 89.599s - Your service is live - Docker Multi-Stage maven:3.9-eclipse-temurin-17 + eclipse-temurin:17-jdk-alpine + mkdir -p uploads - Same as 94 + 95 Live 2m32s

**Tier 10:** 93 Rate Limited API (Live) + 94 URL Shortener Scale (Live 2m32s) + 95 Chat App WebSockets (Live 2m32s - Simple WebSocket TextWebSocketHandler CopyOnWriteArrayList ws://localhost:8097/ws-chat) + 96 Video Streaming API (Live 2m32s - Caching Caffeine 1000 max 600s Stats Redis ready + Security Headers nosniff DENY XSS + Builder Pattern Video.Builder Fluent API + Strategy Pattern Range 206 vs Full + Repository + Caching + JUnit5 Mockito 6/6 Green + viewCount + idx_title + CONTRIBUTING.md 12466 chars + Issues + 16 Badges + Architecture Diagram + Live Link) + 97 Search Elastic + 98 Recommendation + 99 Multi-tenant SaaS + 100 Audit Log + 101 SaaS Idea + 102 Capstone OSS = **TIER 10 FINAL 10 PROJECTS - 94% DONE - Only 6 left to 100%**
