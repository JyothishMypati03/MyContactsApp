# UC-05 : View Contact Details

## 📌 Objective

Implement the **View Contact Details** feature for the **MyContacts App**.

A logged-in user can view the complete details of a specific contact by entering the contact name.

---

## 🎯 Requirements

- Display all available contacts.
- Allow the user to search for a contact by name.
- Show complete details of the selected contact.
- Display a message if the contact is not found.

---

## 🛠 OOP Concepts Used

- Encapsulation
- Getter Methods
- Method Overriding (`toString()`)
- Object-Oriented Design

---

## ☕ Java Concepts Used

- Scanner Class
- ArrayList
- List Interface
- UUID
- LocalDateTime
- String Comparison (`equalsIgnoreCase()`)
- Input Validation
- Packages

---

## 📂 Project Structure

```
src
└── main
    └── java
        └── com
            └── bridgelabz
                └── mycontacts
                    │
                    ├── model
                    │     ├── User.java
                    │     └── Contact.java
                    │
                    ├── validation
                    │     ├── UserValidator.java
                    │     └── ContactValidator.java
                    │
                    ├── auth
                    │     ├── Authentication.java
                    │     ├── BasicAuthentication.java
                    │     └── SessionManager.java
                    │
                    ├── service
                    │     ├── UserAuthenticationService.java
                    │     ├── UserProfileService.java
                    │     └── ContactService.java
                    │
                    └── Main.java
```

---

## 📄 Class Description

### Contact.java

Represents a contact.

Responsibilities:

- Store contact information.
- Generate unique Contact ID.
- Store creation timestamp.
- Display complete contact details using `toString()`.

---

### ContactService.java

Handles contact operations.

Responsibilities:

- Create Contact
- View All Contacts
- View Contact Details

---

### Main.java

Application entry point.

Responsibilities:

- Display menu.
- Read user choice.
- Call Contact Service methods.

---

## 🔄 Contact View Flow

```
User
 │
 ▼
Select "View Contact Details"
 │
 ▼
Enter Contact Name
 │
 ▼
Search Contact List
 │
 ┌──────────────┐
 │              │
 ▼              ▼
Found        Not Found
 │              │
 ▼              ▼
Display      Show
Details      "Contact Not Found"
```

---

## 📋 Features

### 1. View Contact Details

Displays:

- Contact ID
- Owner Email
- Contact Name
- Phone Numbers
- Email Addresses
- Address
- Notes
- Created Date & Time

---

### 2. Search by Contact Name

User enters a contact name.

Example:

```
Rahul
```

The application searches the contact list and displays the matching contact.

---

### 3. Handle Contact Not Found

If the entered contact does not exist, the application displays:

```
Contact not found.
```

---

## ▶️ Sample Output

### Contact Found

```
========== VIEW CONTACT DETAILS ==========

Enter Contact Name : Rahul

Contact Details

ID            : 89d14e5a-9d32-4d6d-a7c3-8e9a52d2a3f1

Owner Email   : jyothish@gmail.com

Name          : Rahul

Phone Numbers : [9876543210, 9123456789]

Email Address : [rahul@gmail.com, rahul.office@gmail.com]

Address       : Bangalore

Notes         : College Friend

Created At    : 2026-07-16T10:45:12
```

---

### Contact Not Found

```
========== VIEW CONTACT DETAILS ==========

Enter Contact Name : Suresh

Contact not found.
```