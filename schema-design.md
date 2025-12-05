# Schema Design - Smart Clinic System

## Tables

### doctor
- id BIGINT PK AUTO_INCREMENT
- name VARCHAR(255)
- speciality VARCHAR(255)
- email VARCHAR(255)
- phone VARCHAR(50)

### patient
- id BIGINT PK AUTO_INCREMENT
- name VARCHAR(255)
- email VARCHAR(255)
- dob DATE
- contact_no VARCHAR(50)
- created_at TIMESTAMP

### appointment
- id BIGINT PK AUTO_INCREMENT
- patient_id BIGINT FK -> patient(id)
- doctor_id BIGINT FK -> doctor(id)
- appointment_time DATETIME
- status VARCHAR(50)

### prescription
- id BIGINT PK AUTO_INCREMENT
- appointment_id BIGINT FK -> appointment(id)
- notes TEXT
- prescribed_at DATETIME

### token
- id BIGINT PK AUTO_INCREMENT
- user_id BIGINT
- token VARCHAR(512)
- expires_at DATETIME

Notes:
- Use indexes on appointment(doctor_id), appointment(patient_id), and appointment(appointment_time) for reporting.
