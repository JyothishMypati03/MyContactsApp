# UC-04 : Create Contact

## 📌 Objective

Implement the **Create Contact** feature for the **MyContacts App**.

A logged-in user can create and store contacts by providing contact details such as name, phone numbers, email addresses, address, and notes.

---

## 🎯 Requirements

- Create a new contact.
- Allow multiple phone numbers.
- Allow multiple email addresses.
- Generate a unique Contact ID.
- Store contact creation time.
- Display all saved contacts.

---

## 🛠 OOP Concepts Used

- Class and Object
- Encapsulation
- Composition
- Constructor
- Collections
- Object Association

---

## ☕ Java Concepts Used

- ArrayList
- List Interface
- UUID
- LocalDateTime
- Scanner
- Regular Expressions (Regex)
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

Represents a contact in the application.

Fields:

- Contact ID
- Owner Email
- Contact Name
- Phone Numbers
- Email Addresses
- Address
- Notes
- Created Time

Responsibilities:

- Store contact information.
- Generate unique ID.
- Store creation timestamp.
- Display contact details.

---

### ContactValidator.java

Validates contact information.

Validation includes:

- Contact Name
- Phone Number
- Email Address

---

### ContactService.java

Handles all contact operations.

Responsibilities:

- Create Contact
- Store Contact
- Display Contacts

---

### Main.java

Application entry point.

Responsibilities:

- Display application menu.
- Call Contact Service.
- Display saved contacts.

---

## 🔄 Contact Creation Flow

```
Logged-in User
       │
       ▼
Select "Create Contact"
       │
       ▼
Enter Contact Name
       │
       ▼
Validate Name
       │
       ▼
Enter Phone Numbers
       │
       ▼
Validate Phone Numbers
       │
       ▼
Enter Email Addresses
       │
       ▼
Validate Email Addresses
       │
       ▼
Enter Address & Notes
       │
       ▼
Generate UUID
       │
       ▼
Store Created Time
       │
       ▼
Create Contact Object
       │
       ▼
Save Contact
```

---

## 📋 Features

### 1. Create Contact

Stores:

- Contact Name
- Multiple Phone Numbers
- Multiple Email Addresses
- Address
- Notes

---

### 2. Automatic Contact ID

Each contact receives a unique identifier using:

```
UUID
```

Example:

```
d4b43d97-3d4c-41f1-9b6d-5a4dfd4e37a2
```

---

### 3. Contact Creation Time

Stores the date and time when the contact was created using:

```
LocalDateTime
```

Example:

```
2026-07-16T10:35:48
```

---

### 4. Multiple Phone Numbers

A contact can have multiple phone numbers.

Example:

```
9876543210

9123456789

9988776655
```

Stored using:

```
List<String>
```

---

### 5. Multiple Email Addresses

A contact can have multiple email addresses.

Example:

```
john@gmail.com

john.office@gmail.com
```

Stored using:

```
List<String>
```

---

## ✅ Validation Rules

### Contact Name

- First letter must be uppercase.
- Minimum 3 characters.

Example:

```
John ✅

john ❌

Jo ❌
```

---

### Phone Number

- Must contain 10 digits.
- Should start with 6, 7, 8, or 9.

Example:

```
9876543210 ✅

1234567890 ❌
```

---

### Email Address

Must follow standard email format.

Example:

```
abc@gmail.com ✅

abc@gmail ❌

abc.com ❌
```

---

## ▶️ Sample Output

```
========== CREATE CONTACT ==========

Enter Contact Name : Rahul

How many phone numbers do you want to add? 2

Enter Phone Number 1 : 9876543210
Enter Phone Number 2 : 9123456789

How many email addresses do you want to add? 2

Enter Email Address 1 : rahul@gmail.com
Enter Email Address 2 : rahul.office@gmail.com

Enter Address : Bangalore

Enter Notes : College Friend

Contact created successfully.
```