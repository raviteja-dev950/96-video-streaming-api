# Contributing to 96 - Video Streaming API - Tier 10 SCALE

Welcome! This project is **96/102 - 94%** of Java 100 Projects Challenge - **Tier 10 System Design Level - Scale + Polish**. We follow strict Tier 10 roadmap compliance.

## Tier 10 Compliance - Scale + Polish

This project demonstrates **SCALE** focus area:

- **Caching:** Caffeine Cache - `CacheConfig.java` - `CaffeineCacheManager maximumSize=1000 expireAfterAccess=600s recordStats()` - `@Cacheable("videos")` + `@Cacheable("video")` + `@CacheEvict(allEntries=true)` - Headers `X-Cache: Caffeine` + `Cache-Control` - Properties `spring.cache.type=caffeine` + `spring.cache.caffeine.spec=maximumSize=1000,expireAfterAccess=600s,recordStats` - Redis pattern ready (replace with `RedisCacheManager` for prod)
- **Security:** `SecurityHeadersConfig.java` - `WebMvcConfigurer` + `HandlerInterceptor` - `X-Content-Type-Options: nosniff` + `X-Frame-Options: DENY` + `X-XSS-Protection: 1; mode=block` - Validation `@NotBlank` title + File empty check + Content-type validation + File size check
- **Design Patterns:** Builder Pattern + Strategy Pattern + Repository Pattern + Caching Pattern
  - **Builder Pattern:** `Video.java` - Inner Builder class - `Video.Builder title() fileName() contentType() fileSize() filePath() uploadedAt() build()` - Fluent API - Used in `VideoService.uploadVideo()`
  - **Strategy Pattern:** `VideoController.stream()` - Range vs Full Strategy - If `Range: bytes=0-1023` header present -> `206 Partial Content` + `Content-Range` + `X-Streaming-Strategy: Range-Strategy-206` Else `200 OK` + `Full-Strategy-200` - Core YouTube/Netflix Streaming System Design
  - **Repository Pattern:** `VideoRepository.java` - `JpaRepository<Video, Long>` + `findAllByOrderByUploadedAtDesc()` + `findByTitleContainingIgnoreCase()` + `idx_title` index
  - **Caching Pattern:** `CacheConfig.java` + `@Cacheable` + `@CacheEvict` - Cache-aside pattern
- **Testing:** JUnit 5 + Mockito - 6 tests Green Bar - `Runs: 6/6 Errors: 0 Failures: 0`
  - `testBuilderPattern()` - Builder Pattern Video - builder.mp4
  - `testVideoEntity()` - Entity Test - Test Video - test.mp4 - 1024 bytes
  - `testFormatVideo()` - Format Video - Date + Views
  - `testGetVideoById_Mockito()` - Mockito - Mocked Repo - `when().thenReturn()` + `verify()`
  - `testGetAllVideos_Mockito()` - Mockito - Mocked 2 videos - Caching: videos
  - `testSearchVideos_Mockito()` - Search + Caching - Found 1 video for keyword Test

## Project Structure

```
96-video-streaming-api/
├── src/main/java/com/videostreaming/
│   ├── VideoStreamingApplication.java - Port 8098 local, 10000 Render, Tomcat 10.1.20, Started 13.014s local, 89.599s Render
│   ├── config/
│   │   ├── CacheConfig.java - Tier 10 Caching - Caffeine 1000 max 600s expire Stats Redis ready
│   │   └── SecurityHeadersConfig.java - Tier 10 Security - nosniff, DENY, XSS Protection Interceptor
│   ├── controller/
│   │   └── VideoController.java - Upload, List, Stream Range 206 Strategy, Search, Headers X-Cache, X-Streaming-Strategy, Content-Range
│   ├── service/
│   │   └── VideoService.java - Builder Pattern + Cacheable + CacheEvict + viewCount + idx_title
│   ├── model/
│   │   └── Video.java - Builder Pattern + Builder inner class + viewCount + uploadedAt + fileName + filePath + fileSize + contentType + title
│   └── repository/
│       └── VideoRepository.java - Repository Pattern + findAllByOrderByUploadedAtDesc + findByTitleContainingIgnoreCase + Search
├── src/test/java/com/videostreaming/
│   └── VideoServiceTest.java - JUnit5 + Mockito - 6 tests Green - Builder + Entity + Format + Mockito Mock Repo
├── src/main/resources/
│   └── application.properties - jdbc:h2:mem:videodb (FIXED from dbc typo), spring.cache.type=caffeine, spec=maximumSize=1000,expireAfterAccess=600s,recordStats, server.port=8098 local 10000 Render
├── Dockerfile - Multi-Stage - FROM maven:3.9-eclipse-temurin-17 AS build + FROM eclipse-temurin:17-jdk-alpine + mkdir -p uploads + COPY --from=build target/*.jar app.jar - FIXED openjdk:17-jdk-slim not found + COPY target/*.jar error
├── pom.xml - Java 17, Spring Boot 3.2.5, spring-boot-starter-cache + caffeine + spring-boot-starter-data-jpa + validation + H2 + JUnit5 + Mockito + ByteBuddy
├── CONTRIBUTING.md - This file - 1000+ chars - Tier 10 GitHub Goal
├── .github/ISSUE_TEMPLATE/
│   ├── bug_report.md - Bug report template - Labels bug, Tier 10, System Design
│   └── feature_request.md - Feature request template - Labels enhancement, Tier 10
├── README.md - 16 Badges + Architecture Diagram + Live Link + Demos 12 + Flow Diagram Caching + Security + Design Patterns + Range 206
└── uploads/ - Video uploads directory - mkdir -p in Dockerfile - .gitignore
```

## Local Setup - Eclipse Tier 10 - No Zip - Step by Step

1. **Clone:**
```
git clone https://github.com/raviteja-dev950/96-video-streaming-api.git
cd 96-video-streaming-api
```

2. **Eclipse:**
- File -> Import -> Existing Maven Projects -> Select folder `96-video-streaming-api` -> Finish
- If `VideoController.java` red errors -> Delete folder `src/main/resources/META-INF` + Delete `target` folder -> Right Click Project -> Maven -> Update Project -> Check Force Update -> OK -> Wait Maven dependencies download (caffeine, cache, H2, JUnit5, Mockito)
- If `URL must start with 'jdbc'` error -> Check `application.properties` -> Must be `jdbc:h2:mem:videodb` NOT `dbc:h2:mem:videodb` (missing j) -> Fixed in Tier 10 version + Removed `driverClassName` + `database-platform` lines (Tier 9 pattern)

3. **Run:**
- Right Click `VideoStreamingApplication.java` -> Run As -> Java Application
- Console: `Tomcat initialized port 8098` + `HikariPool-1 conn0 jdbc:h2:mem:videodb` + `create table video (id, file_name, file_path, file_size, title, content_type, uploaded_at, view_count) + create index idx_title` + `Tomcat started port 8098` + `Started Application in 13.014s`

4. **Test Tier 10 Demos:**
- Demo1 Home: `http://localhost:8098/` -> tier 10, focusArea Scale + Polish, caching Caffeine, security nosniff DENY XSS, designPatterns Builder+Strategy+Repository+Caching, testing JUnit5 Mockito 6 tests Green
- Demo2 Health: `http://localhost:8098/health` -> UP, cache Active Caffeine Stats enabled, security Headers Active, githubGoal CONTRIBUTING.md + Issues + Release Tags v1.0.0
- Demo3 Empty: `GET http://localhost:8098/api/videos` -> [] + Header X-Cache: Caffeine - videos
- Demo4 Upload: `POST http://localhost:8098/api/videos/upload` Form-data file + title -> 200 OK -> id 1, Builder Pattern, Cache Evicted
- Demo5 List: `GET http://localhost:8098/api/videos` -> viewCount 0 + X-Cache header
- Demo6 Stream Range: `GET http://localhost:8098/api/videos/1/stream` + Header Range: bytes=0-1023 -> 206 Partial Content + Content-Range + X-Streaming-Strategy: Range-Strategy-206
- Demo7 JUnit Green: `Runs: 6/6 Errors: 0 Failures: 0` Green Bar
- Demo8 JUnit Console: Builder Pattern Test Passed + Mockito Test Passed + Search Test Passed
- Demo9 Eclipse Console: Tomcat started on port 8098 + Started Application in 13.014s + idx_title + view_count

5. **Build JAR:**
```
mvn clean package -DskipTests
```

## Reporting Issues - GitHub Goal

- Go to Issues -> New Issue -> Choose template `Bug Report` or `Feature Request`
- **Bug Report:** Labels `bug, Tier 10, System Design` - Describe Caching, Security, Design Patterns, Testing issue
- **Feature Request:** Labels `enhancement, Tier 10` - Suggest new feature like Elasticsearch integration for Project 97

## Pull Requests - Tier 10

1. Fork repo `96-video-streaming-api`
2. Create branch `feature/your-feature-name`
3. Commit message format: `96 Tier 10 SCALE - Description - Caching/Security/Design Patterns/Testing - 96/102 94%`
4. Push branch -> Create PR -> Link issue -> Mention Tier 10 compliance
5. Ensure `Runs: 6/6 Green Bar` + `mvn clean package` success + Tomcat 8098 13.014s

## Release Tags - GitHub Goal

- `v1.0.0` - Initial Release - Tier 10 SCALE - Caching Caffeine 1000 max 600s Stats + Security Headers nosniff DENY XSS + Builder Pattern + Strategy Pattern Range 206 + Repository + Caching + JUnit5 Mockito 6 tests Green + viewCount + idx_title + CONTRIBUTING.md + Issues + 16 Badges + Architecture Diagram + Live Link + Docker Multi-Stage + Render Live 2m32s
- Create release: `git tag v1.0.0 -m "96 Tier 10 SCALE"` + `git push origin v1.0.0` -> GitHub -> Releases -> Draft New Release

## Architecture Diagram - Tier 10

```
User (Postman / Browser)
  ↓ POST /api/videos/upload + title + file (71MB)
  ↓ GET /api/videos + X-Cache: Caffeine
  ↓ GET /api/videos/{id}/stream + Range: bytes=0-1023 -> 206 Partial Content
VideoController.java
  ├─ SecurityHeadersConfig.java -> Interceptor -> nosniff + DENY + XSS + Validation
  ├─ CacheConfig.java -> CaffeineCacheManager -> maximumSize=1000 -> expireAfterAccess=600s -> recordStats() -> @Cacheable + @CacheEvict -> X-Cache + Cache-Control -> Redis pattern ready
  ├─ VideoService.java -> Builder Pattern -> Video.Builder -> Fluent API -> CacheEvict on upload
  └─ Strategy Pattern -> Range vs Full -> Range-Strategy-206 -> 206 + Content-Range + Accept-Ranges + X-Streaming-Strategy Else Full-Strategy-200 -> 200 OK
VideoRepository.java -> Repository Pattern -> JpaRepository + findAllByOrderByUploadedAtDesc + findByTitleContainingIgnoreCase -> idx_title index + view_count
H2 Database -> videodb -> jdbc:h2:mem:videodb (FIXED from dbc typo) -> table video + index idx_title
Uploads Directory -> uploads/ -> mkdir -p in Dockerfile
Docker Multi-Stage -> maven:3.9-eclipse-temurin-17 AS build + eclipse-temurin:17-jdk-alpine + COPY --from=build
Render -> Runtime Docker -> PORT=10000 -> Deploy succeeded Live 2m32s -> Your service is live -> Live URL https://nine6-video-streaming-api.onrender.com
JUnit5 + Mockito -> VideoServiceTest.java -> @Mock + @InjectMocks + when().thenReturn() + verify() -> 6 tests Green Bar
```

## Testing - Tier 10 - JUnit5 + Mockito

- Framework: JUnit 5 + Mockito + ByteBuddy Agent + Spring Boot Starter Test
- Run: Right Click VideoServiceTest.java -> Run As -> JUnit Test -> Green Bar 6/6
- Coverage: Builder Pattern + Entity + Format + Mockito getById + getAll + Search - Was 2/2 Tier 5 -> Now 6/6 Tier 10 - Roadmap PASS

## Live Links - Tier 10

- Local: http://localhost:8098/ + /health + /api/videos + /api/videos/{id}/stream + /api/videos/search
- Render Live: https://nine6-video-streaming-api.onrender.com - Deploy succeeded Live 2m32s - Tomcat 10000 - Started 89.599s
- GitHub: https://github.com/raviteja-dev950/96-video-streaming-api - 45 objects, 727.96 KiB push pattern
- Profile: 96/102 94% - Only 6 left to 100% - Tier 10 System Design Level

## Code Style - Tier 10

- Java 17 + Spring Boot 3.2.5 + Builder Pattern - Fluent API - No telescoping constructor
- Strategy Pattern - Range vs Full - 206 Partial Content - YouTube/Netflix streaming
- Caching Pattern - Cache-aside - @Cacheable + @CacheEvict - Stats enabled - Redis ready
- Security Headers - Interceptor - nosniff DENY XSS - Validation
- JUnit5 Mockito - @Mock + @InjectMocks + when().thenReturn() + verify()
- No dbc typo - Must be jdbc:h2:mem:videodb - Fixed from initial bug
- No META-INF folder - Delete if Eclipse creates it - Maven Update Force
- Dockerfile Multi-Stage - eclipse-temurin:17-jdk-alpine NOT openjdk:17-jdk-slim

## GitHub Goal - Tier 10

- ✅ CONTRIBUTING.md - This file - 1000+ chars - Tier 10
- ✅ Issues - .github/ISSUE_TEMPLATE/bug_report.md + feature_request.md
- ✅ Release Tags - v1.0.0 - Initial Release - Tier 10 SCALE - Live 2m32s
- ✅ Badges - 16 Badges - Build passing, coverage, deployed link
- ✅ Live Link - https://nine6-video-streaming-api.onrender.com + localhost:8098
- ✅ Architecture Diagram - Flow Diagram Caching + Security + Design Patterns + Range 206 + Docker + Render
- ✅ Deployed Link - Render Live 2m32s - Deploy succeeded - Your service is live

Thank you for contributing to Tier 10 SCALE! Together we build 96/102 94% -> 100/102 98% -> 102/102 100% Capstone OSS Tool!

## License

MIT License - Same as all Java 100 Projects - Open Source - Feel free to use for learning System Design Level - Caching, Security, Testing, Design Patterns - JUnit, Mockito, Redis, Elasticsearch - Project 96 Video Streaming API - Part of Tier 10 Scale + Polish
