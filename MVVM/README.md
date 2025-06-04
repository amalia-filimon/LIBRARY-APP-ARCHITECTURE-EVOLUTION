# MVVM – Library Chain Management System 📚

This project represents the second stage of the library chain management system, implementing the **Model-View-ViewModel (MVVM)** architectural pattern. It expands on the initial MVP version by introducing improved separation of concerns and adds new export functionalities.

---

## 🧩 Problem Statement

The application manages a library network with three user roles:

- **Employee** – works in a specific library
- **Manager** – oversees multiple libraries
- **Administrator** – manages all users

Each role has a dedicated user interface and access to specific operations, enabled after login authentication.

---

## ✅ Functionalities

### 🔹 Employee
- View books in the assigned library
- Sort books by author or title
- Filter books by:
  - Domain
  - Availability
  - Publisher
  - Author
  - Price
- Add, update, and delete books
- Export book list in:
  - `.csv`
  - `.json`
  - `.xml`
  - `.txt`

### 🔹 Manager
- View books from any selected library
- Apply the same filters as employees
- Export filtered results in multiple formats

### 🔹 Administrator
- View all users in the system
- Filter by user type
- Add, update, and delete users

---

## 🧱 Architecture: Model-View-ViewModel (MVVM)

This version follows the **MVVM** pattern:
- **Model** – holds the data and business logic
- **View** – Swing UI components
- **ViewModel** – mediates between model and view, handling commands and user interaction

The UI is **event-driven** and connected via action listeners to ViewModel commands.

---

## 🛠️ Technologies

- Java
- Swing (GUI)
- File export (CSV, JSON, XML, TXT)
- Maven
- MVVM custom implementation (not a framework)
