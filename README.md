# Smart Clinic System - Minimal Backend

This repo contains a minimal Spring Boot backend stub for the Smart Clinic Management System used for capstone submission.

## How to run locally

1. Build:

./mvnw clean package

2. Run:

java -jar target/smart-clinic-system-0.0.1-SNAPSHOT.jar


API endpoints (minimal stubs):
- `GET /api/doctors` - list doctors
- `GET /api/doctors/search?speciality=Cardiology` - search
- `POST /api/prescriptions` - create prescription (stub)

