🩺 Doctor Table
| Field Name | Data Type    | Description                                |
| ---------- | ------------ | ------------------------------------------ |
| id         | BIGINT (PK)  | Unique identifier for each patient         |
| name       | VARCHAR(100) | Patient’s full name (NOT NULL)             |
| email      | VARCHAR(100) | Patient’s email address (UNIQUE, NOT NULL) |
| phone      | VARCHAR(15)  | Patient’s contact number (NOT NULL)        |

🧑 Patient Table
| Field Name | Data Type    | Description                                |
| ---------- | ------------ | ------------------------------------------ |
| id         | BIGINT (PK)  | Unique identifier for each patient         |
| name       | VARCHAR(100) | Patient’s full name (NOT NULL)             |
| email      | VARCHAR(100) | Patient’s email address (UNIQUE, NOT NULL) |
| phone      | VARCHAR(15)  | Patient’s contact number (NOT NULL)        |
📅 Appointment Table
| Field Name       | Data Type   | Description                                 |
| ---------------- | ----------- | ------------------------------------------- |
| id               | BIGINT (PK) | Unique identifier for each appointment      |
| appointment_time | DATETIME    | Date and time of the appointment (NOT NULL) |
| doctor_id        | BIGINT (FK) | References `Doctor(id)`                     |
| patient_id       | BIGINT (FK) | References `Patient(id)`                    |
🔗 Relationships

Doctor ↔ Appointment: One doctor can have multiple appointments (One-to-Many).

Patient ↔ Appointment: One patient can book multiple appointments (One-to-Many).

The Appointment table serves as a junction table connecting doctors and patients.

✅ Explicit Foreign Key Constraints
ALTER TABLE appointment
ADD CONSTRAINT fk_doctor
FOREIGN KEY (doctor_id) REFERENCES doctor(id);

ALTER TABLE appointment
ADD CONSTRAINT fk_patient
FOREIGN KEY (patient_id) REFERENCES patient(id);

