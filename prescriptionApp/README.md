# 💊 Digital Prescription Management Tool (Backend)

A secure, scalable backend system for managing e-prescriptions and medication history using **Spring Boot**, **PostgreSQL**, and **JWT-based authentication**.

---

## 🚀 Tech Stack

- **Backend**: Spring Boot 3 (Java 24)
- **Database**: PostgreSQL 14
- **ORM**: Spring Data JPA
- **Authentication**: Spring Security + JWT (planned)
- **Build Tool**: Maven 3.9
- **Version Control**: Git + GitHub

---

## 📦 Features

- 👤 User management with role-based access (`DOCTOR`, `PATIENT`)
- 📝 Create & manage digital prescriptions
- 📚 Track patient medication history
- 🔐 Secure REST APIs (JWT coming soon)
- 🗄️ PostgreSQL integration

---

## 🛠️ Getting Started

### 1. Prerequisites

- Java 24
- PostgreSQL 14 installed and running
- Maven 3.9
- IDE (e.g., IntelliJ IDEA or VSCode)

### 2. Set up the Database

In your terminal:

```bash
psql -U postgres
CREATE DATABASE prescription_db;
```
Update src/main/resources/application.properties with your DB credentials.

### 3. Run the Application
```bash
./mvnw spring-boot:run
```
The backend will run at http://localhost:8080

## 🔄 Project Structure
```
src/
├── controller/ # REST endpoints 
├── model/ # JPA entities (User, Prescription, Role)
├── repository/ # Spring Data JPA interfaces
├── service/ # Business logic (coming up)
├── config/ # Spring Security & JWT (coming up)
└── dto/ # Request/response models (planned)
```


---

## 🧪 Coming Soon

- ✅ JWT-based authentication
- ✅ Register/Login endpoints
- ✅ Swagger API documentation
- ✅ Angular frontend integration
- ✅ Role-based authorization for doctors & patients

---

## 🧑‍💻 Author

**Keerthana Turai**  
[🔗 GitHub Profile](https://github.com/KeerthanaTurai)

---

## 📄 License

This project is open-source under the [MIT License](LICENSE).