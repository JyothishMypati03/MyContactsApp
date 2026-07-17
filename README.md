# UC-08 : Bulk Operations

## 📌 Objective

Implement the **Bulk Operations** feature for the **MyContacts App**.

A logged-in user can perform operations on multiple contacts at the same time, such as deleting multiple contacts, adding a common tag, and exporting contacts to a file.

---

## 🎯 Requirements

- Delete multiple contacts in one operation.
- Add the same tag to multiple contacts.
- Export all contacts to a text file.
- Display success or error messages after each operation.

---

## 🛠 OOP Concepts Used

- Encapsulation
- Object-Oriented Design
- Collections
- Object Manipulation
- Reusability

---

## ☕ Java Concepts Used

- ArrayList
- List Interface
- Set Interface
- LinkedHashSet
- Scanner
- Enhanced For Loop
- Java NIO (`Files`, `Path`, `Paths`)
- Exception Handling (`try-catch`)
- String Methods (`split()`, `trim()`)
- CRUD Operations

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
- Store tags.
- Generate unique Contact ID.
- Display contact details.

---

### ContactService.java

Handles all contact-related operations.

Responsibilities:

- Create Contact
- View Contact
- Edit Contact
- Delete Contact
- Bulk Delete Contacts
- Bulk Add Tags
- Export Contacts

---

### Main.java

Application entry point.

Responsibilities:

- Display menu.
- Read user choice.
- Call Contact Service methods.

---

# 🔄 Bulk Operations Flow

```
Logged-in User
       │
       ▼
Select Bulk Operations
       │
       ▼
Choose Operation
       │
 ┌─────┼───────────────┐
 │     │               │
 ▼     ▼               ▼
Delete Tag         Export
 │     │               │
 ▼     ▼               ▼
Perform Operation
       │
       ▼
Display Result
```

---

# 📋 Features

## 1. Bulk Delete Contacts

Delete multiple contacts in one operation.

Example input

```
Rahul,Ramesh,Priya
```

All matching contacts are removed.

---

## 2. Bulk Add Tag

Add the same tag to multiple contacts.

Example

```
Contacts

Rahul

Ramesh

Priya

↓

Tag

Friends
```

After operation

```
Rahul

Tags

Friends

----------------

Ramesh

Tags

Friends

----------------

Priya

Tags

Friends
```

---

## 3. Export Contacts

Exports every contact to a text file.

Example

```
contacts-export.txt
```

The file contains complete contact information.

---

# ▶️ Sample Output

### Bulk Delete

```
========== BULK OPERATIONS ==========

1. Bulk Delete Contacts

2. Bulk Add Tag

3. Export Contacts

4. Back

Enter Choice : 1

Enter contact names to delete

Rahul,Ramesh

Selected contacts deleted successfully.
```

---

### Bulk Tag

```
Enter contact names

Rahul,Priya

Enter Tag

Family

Tag added to 2 contact(s).
```

---

### Export

```
Enter export file name

contacts.txt

Contacts exported successfully.

Location

contacts.txt
```