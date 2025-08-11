## Blog Application (Spring Boot + React)

### Overview
Full‑stack blog platform built with Spring Boot (API) and React + Vite (UI). It features JWT authentication, categories and tags, rich‑text editing, and a clean UI. Database schema and seed data are managed via Liquibase.

### Tech Stack
- Backend: Java, Spring Boot 3, Spring Security (JWT), Spring Data JPA, MapStruct, Liquibase, PostgreSQL
- Frontend: React 18, TypeScript, Vite, NextUI, Axios, React Router
- Build/Tools: Gradle, Docker Compose (PostgreSQL), H2 for tests

### Project Structure
```
blog/
  blog-api/   # Spring Boot backend
  blog-ui/    # React + Vite frontend
```

## Getting Started

### Prerequisites
- Java 17+
- Node.js 18+
- Docker (for local PostgreSQL)

### 1) Start PostgreSQL (Docker)
From `blog/blog-api` directory:
```
docker-compose up -d
```
Backend is preconfigured for:
- URL: jdbc:postgresql://localhost:5433/blog
- User: user
- Password: password

You can adjust these in `blog-api/src/main/resources/application.yaml` if needed.

### 2) Run Backend (API)
From `blog/blog-api` directory:
```
./gradlew bootRun    # Linux/macOS
gradlew.bat bootRun  # Windows
```
The API will start on `http://localhost:8080`.

Liquibase is enabled and will create the schema and load seed data on startup.

#### Seeded Data
- Default user: email `user@test.com`, password `password`
- Several categories, tags, and example posts

JWT settings (secret and expiration) are configured in `application.yaml`. For production, override them via environment variables or externalized config.

### 3) Run Frontend (UI)
From `blog/blog-ui` directory:
```
npm install
npm run dev
```
UI runs on `http://localhost:5173` and proxies API requests (`/api`) to `http://localhost:8080` (see `vite.config.ts`).


