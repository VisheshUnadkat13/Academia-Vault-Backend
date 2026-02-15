# Academia-Vault-Backend

# Database Architecture

<img width="1325" height="990" alt="Academia Vault DataBase Design" src="https://github.com/user-attachments/assets/322c344c-342b-48ac-86c7-3f3805b948f7" />


#Backend Architecture

<img width="784" height="1680" alt="updated Academia Vault Architectre" src="https://github.com/user-attachments/assets/3a9cb049-2d6f-4781-a9ed-d39377923774" />


🎓 Academia Vault

A fun full-stack academic resource platform built to refine backend, database, and frontend fundamentals using Spring Boot and React.js.

📌 About The Project

Academia Vault is a student-focused web application designed to centralize academic resources in one place.
This is not a complex enterprise-level system — it is a learning-focused full-stack project built to strengthen my understanding of:

Java & Spring Boot
Spring Security with JWT
REST API development
Database design using PostgreSQL
React.js frontend integration
The main goal was to solve a common student problem:
Academic resources like previous year papers, YouTube lectures, GATE materials, and subject notes are often scattered across different platforms.

This project brings them together in a structured and secure way.

🚀 Features
🔐 1. User Authentication & Authorization

Implemented using Spring Security + JWT (Stateless Authentication).

Authentication Flow:

When a user visits for the first time → Signup required
After successful signup → Redirect to Login page
After login → Redirect to Main Landing Page
Returning users → Direct Login (No re-signup required)
JWT token validates every protected API request

✔ Stateless authentication
✔ Secure API access
✔ Role-based access control

🎯 2. Branch & Semester Based Resource Access

After login, the user:
Selects their Branch
Selects their Semester
Gets access to subject-specific resources

📚 3. Academic Resources Provided

For each subject, students can access:
📄 Previous Year Question Papers
📺 YouTube Videos (Relevant for GTU Examination)
📘 GATE Preparation Material
📚 Subject-wise Study Materials
All resources are mapped logically to ensure relevance.

🛠 Tech Stack
🔹 Frontend

React.js
Axios (API communication)
Plain CSS

🔹 Backend

Spring Boot
Spring Data JPA
Spring Security
JWT Authentication
RESTful APIs

🔹 Database
PostgreSQL

🏗 Architecture Overview

Frontend (React.js)
⬇
REST APIs (Spring Boot)
⬇
Service Layer (Business Logic)
⬇
Spring Data JPA
⬇
PostgreSQL Database
JWT is used for secure stateless communication between frontend and backend.

🔐 Security Implementation

Password encryption using BCrypt
JWT-based stateless authentication
Protected endpoints using Spring Security
User-specific resource access
Proper request authorization checks

📂 Core Modules

User Module (Signup / Login)
Branch & Semester Selection
Subject Management
Previous Year Paper Module
YouTube Video Integration (GTU-focused)
GATE Material Module
Study Material Module

🎯 Learning Objectives Achieved

Through this project, I strengthened my understanding of:
REST API design
Entity relationships in JPA
Authentication & Authorization flow
Stateless security using JWT
Frontend-backend integration
Database schema design
Clean layered architecture (Controller → Service → Repository)

🌱 Future Improvements (Planned)

📝 Personal Notes per Subject (private notes for students)
🔎 Global Search across subjects, materials, notes, and PYQs
⭐ Bookmark / Favorite resources
📊 Basic usage analytics dashboard
🎨 UI improvements and better UX

⚠️ Disclaimer

This is a fun learning project created to refine full-stack development skills.
It is not intended as a production-ready academic platform.

👨‍💻 Author

Vishesh Unadkat
Aspiring Backend / Full Stack Developer
Focused on Java, Spring Boot, and scalable backend systems.
