# MySQL Schema Design

## Doctor
- id BIGINT PK
- name VARCHAR(100)
- email VARCHAR(100)
- specialty VARCHAR(50)
- available_times JSON

## Patient
- id BIGINT PK
- name VARCHAR(100)
- email VARCHAR(100)
- phone VARCHAR(15)

## Appointment
- id BIGINT PK
- appointment_time DATETIME
- doctor_id FK
- patient_id FK
