# MVC – Library Chain Management System 📚

This is the third stage in the development of the library chain management application. It uses the **Model-View-Controller (MVC)** architectural pattern and enhances the system by adding graphical statistics, advanced exports, and improved user interaction.

---

## 🧩 Problem Statement

The application supports three user roles:

- **Employee** – manages books in one library
- **Manager** – oversees all libraries and generates reports
- **Administrator** – manages user accounts

Each role is granted access to specific interfaces and operations after authentication.

---

## ✅ Functionalities

### 🔹 Common
- Role-based login
- Multilingual GUI (Romanian, English, French, Spanish)

### 🔹 Employee
- View, add, edit, delete books
- Sort and filter by:
  - Title
  - Author
  - Domain
  - Availability
  - Publisher
  - Price
- Export book list to `.csv`, `.json`, `.xml`, `.txt`

### 🔹 Manager
- View books from all libraries
- Filter and sort results
- Export reports (same formats as employee)
- **View statistics**: number of books by domain (as bar chart)

### 🔹 Administrator
- Manage system users (create, update, delete)
- Filter by user type (Employee / Manager / Administrator)

---

## 🧱 Architecture: Model-View-Controller (MVC)

This version uses the **MVC** pattern:
- `Model`: data and business logic
- `View`: Java Swing UI
- `Controller`: handles user actions and updates model/view accordingly

---

## 📈 Statistics Feature

The Manager role includes a **graphical bar chart** showing the number of books by domain across all libraries. This is implemented using the `JFreeChart` library.

---

## 🛠️ Technologies Used

- Java
- Swing
- JFreeChart (for bar charts)
- Export: CSV, JSON, XML, TXT
- Maven
