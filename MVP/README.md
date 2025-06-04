# MVP – Library Chain Management System 📚

This project is the first stage of a library chain management system. It is implemented using the **Model-View-Presenter (MVP)** architectural pattern and simulates the operations of a library chain with three user roles.

---

## 🧩 Problem Statement

The application models a library network with 3 user types:

- **Employee**: manages books in their assigned library
- **Manager**: views and filters books in a selected library
- **Administrator**: manages user accounts

Each user must authenticate before accessing the application, and their access is restricted based on role.

---

## ✅ Functionalities

### 🔹 Common
- Role-based login interface with error handling

### 🔹 Employee
- View and manage books in own library
- Sort books by author and title
- Filter books by:
  - Domain
  - Availability
  - Publisher
  - Author
  - Price
- Add, edit, and delete books

### 🔹 Manager
- Select a library and view its books
- Apply advanced filters (same as employee)

### 🔹 Administrator
- View all users in the system
- Add, edit, and delete users
- Filter users by role

---

## 🧱 Architecture: Model-View-Presenter (MVP)

This version implements the **MVP** pattern:
- `model` – domain entities and logic (Book, Library, User)
- `view` – Swing-based user interface components
- `presenter` – intermediaries handling business logic and UI interaction

Each role has its own view and presenter.

---

## 🛠️ Technologies

- **Java**
- **Swing** (GUI)
- **Text files** (for data persistence)
- **Maven**
- **StarUML** (for diagrams)

---
