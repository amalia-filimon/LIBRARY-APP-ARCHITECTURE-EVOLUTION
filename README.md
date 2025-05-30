# 📚 Library Chain Management System

This repository contains the full evolution of a library chain management system. The application simulates the operations of a library network with three user roles: **Employee**, **Manager**, and **Administrator**.

The project is implemented in **Java** and structured across multiple stages, each highlighting a different architectural pattern or software design concept.

---

## 📦 Project Structure

| Folder           | Description                                                   |
|------------------|---------------------------------------------------------------|
| `MVP/`           | Initial version using **Model-View-Presenter** architecture   |
| `MVVM/`          | Second version based on **Model-View-ViewModel** pattern      |
| `MVC/`           | Third version using **Model-View-Controller** pattern         |
| `CLIENT-SERVER/`  | Final version with **Client-Server** communication over sockets |

Each stage builds upon the previous one by adding new functionality and improving architecture.

---

## 👤 User Roles & Features

### 🔹 Employee
- View books in assigned library (sorted by author/title)
- Filter and search books by criteria (domain, price, availability, etc.)
- CRUD operations for book records
- Sell books
- Export data in CSV, JSON, XML, TXT

### 🔹 Manager
- Access book data across libraries
- Apply filters and search
- Export global reports in multiple formats
- View graphical statistics (MVC only)

### 🔹 Administrator
- Manage users (CRUD operations)
- Filter and view all users by type

---

## 🧱 Technologies Used

- **Java**
- **Swing** (for GUI)
- **Java Sockets** (Client-Server)
- **MySQL** (for persistence)
- **Maven** (project build)
- **JDBC** (database access)
- Export formats: CSV, JSON, XML, TXT

---
