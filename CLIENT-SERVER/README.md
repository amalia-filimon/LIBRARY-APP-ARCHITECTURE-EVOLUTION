# Client-Server – Library Chain Management System 📚

This is the final stage of the project, where the application is split into two separate components: a **Java server** and a **Swing-based desktop client**. The two communicate via custom Java socket protocols using serialized objects.

This version maintains the core features from the MVC stage while adding a modular, distributed architecture.

---

## 🔗 Architecture Overview

- The client sends `Request` objects to the server
- The server handles logic and database access
- The server replies with `Response` objects
- All communication uses `ObjectInputStream` and `ObjectOutputStream`

---

## 🧑‍💼 User Roles & Capabilities

> 🌍 The client interface is multilingual: Romanian, English, French, and Spanish.

### 🔹 Employee
- View, add, edit, and delete books
- Sort and filter by various criteria
- Export book lists (CSV, JSON, XML, TXT)

### 🔹 Manager
- Access book data from all libraries
- Apply complex filters
- Export results in multiple formats
- View bar chart statistics (books per domain)

### 🔹 Administrator
- Manage users (create, update, delete)
- Filter and list users by type (employee, manager, admin)

---

## 🛠️ Technologies Used

- **Java**
- **Swing** (GUI)
- **Java Sockets**
- **Object serialization**
- **MySQL** (for persistence)
- **JDBC**
- **Maven**
- **JFreeChart** (for bar charts)
- Export formats: `.csv`, `.json`, `.xml`, `.txt`

