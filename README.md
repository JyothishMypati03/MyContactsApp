# UC-02 : User Authentication

## 📌 Objective

Implement the User Authentication feature for the **MyContacts App**.

A registered user can log in using their email and password to access the application.

---

## 🎯 Requirements

- Login using registered email and password.
- Validate user credentials.
- Authenticate the user.
- Create a user session after successful login.
- Display login success or failure message.

---

## 🛠 OOP Concepts Used

- Interface
- Implementation
- Polymorphism
- Encapsulation
- Singleton Design Pattern

---

## ☕ Java Concepts Used

- Scanner Class
- Interface
- Method Overriding
- Object Creation
- Constructor Injection
- Session Management
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
                    │     └── User.java
                    │
                    ├── auth
                    │     ├── Authentication.java
                    │     ├── BasicAuthentication.java
                    │     └── SessionManager.java
                    │
                    ├── service
                    │     └── UserAuthenticationService.java
                    │
                    └── Main.java
```

---

## 📄 Class Description

### User.java

Stores registered user details.

Fields:

- Name
- Email
- Password

Responsibilities:

- Store user information.
- Provide getter methods.
- Display user information.

---

### Authentication.java

Authentication interface.

Responsibilities:

- Define the login method.
- Allow multiple authentication implementations.

---

### BasicAuthentication.java

Implements the Authentication interface.

Responsibilities:

- Compare entered email and password.
- Return login status.

---

### SessionManager.java

Singleton class.

Responsibilities:

- Maintain the currently logged-in user.
- Store user session.
- Provide logout functionality.

---

### UserAuthenticationService.java

Handles authentication logic.

Responsibilities:

- Receive login request.
- Call authentication implementation.
- Create session on successful login.
- Return authentication result.

---

### Main.java

Application entry point.

Responsibilities:

- Read login credentials.
- Call authentication service.
- Display login result.

---

## 🔄 Authentication Flow

```
User
   │
   ▼
Enter Email & Password
   │
   ▼
UserAuthenticationService
   │
   ▼
Authentication Interface
   │
   ▼
AuthenticationConfig
   │
   ▼
Credentials Match?
   │
 ┌─┴───────────┐
 │             │
Yes            No
 │             │
 ▼             ▼
Session      Login Failed
Created
```

---

## ▶️ Sample Output

### Successful Login

```
========== USER LOGIN ==========

Enter Email : jyothish@gmail.com
Enter Password : Java@123

Login Successful!

Welcome Jyothish
```

---

### Failed Login

```
========== USER LOGIN ==========

Enter Email : jyothish@gmail.com
Enter Password : Java123

Invalid Email or Password!
```