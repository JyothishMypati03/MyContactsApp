# UC-01 : User Registration

## 📌 Objective

Implement the User Registration feature for the **MyContacts App**.

A new user can create an account by entering their name, email address, and password. The application validates all inputs before creating the user account.

---

## 🎯 Requirements

- Register a new user.
- Accept user details from the console.
- Validate Name.
- Validate Email.
- Validate Password.
- Display registration success message.

---

## 🛠 OOP Concepts Used

- Class and Object
- Encapsulation
- Constructor
- Getters
- Method Overriding (`toString()`)

---

## ☕ Java Concepts Used

- Scanner Class
- Regular Expressions (Regex)
- Pattern Class
- while Loop
- Input Validation
- Packages
- Object Creation

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
                    │     └── User.java
                    │
                    ├── validation
                    │     └── UserValidator.java
                    │
                    ├── service
                    │     └── UserRegistrationService.java
                    │
                    └── Main.java
```

---

## 📄 Class Description

### User.java

Stores user information.

Fields:

- Name
- Email
- Password

Responsibilities:

- Store user details
- Provide getters
- Display user information

---

### UserValidator.java

Validates user input using Regular Expressions.

Validation includes:

- Name
- Email
- Password

---

### UserRegistrationService.java

Handles the complete registration process.

Responsibilities:

- Read user input
- Validate input
- Create User object
- Return registered user

---

### Main.java

Application entry point.

Responsibilities:

- Start the application
- Call registration service
- Display registered user information

---

## ✅ Validation Rules

### Name

- First letter must be uppercase.
- Minimum 3 characters.

Example:

```
Jyothish ✅

jyothish ❌

Jo ❌
```

---

### Email

Must follow standard email format.

Example:

```
abc@gmail.com ✅

abc@gmail ❌

abc.com ❌
```

---

### Password

Password must contain:

- Minimum 8 characters
- One uppercase letter
- One digit
- One special character

Example:

```
Java@123 ✅

java123 ❌

JAVA123 ❌
```

---

## ▶️ Sample Output

```
=================================
      USER REGISTRATION
=================================

Enter Name : Jyothish

Enter Email : jyothish@gmail.com

Enter Password : Java@123

Registration Successful!

User Details

Name  : Jyothish

Email : jyothish@gmail.com
```

---
