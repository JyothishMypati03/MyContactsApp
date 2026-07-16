# UC-03 : User Profile Management

## 📌 Objective

Implement the **User Profile Management** feature for the **MyContacts App**.

A logged-in user can view and update profile information, change their password, and manage personal preferences.

---

## 🎯 Requirements

- View user profile.
- Update profile information.
- Change password.
- Update user preferences.
- Validate user inputs before updating.

---

## 🛠 OOP Concepts Used

- Encapsulation
- JavaBeans Convention (Getters & Setters)
- Object-Oriented Design
- Method Abstraction

---

## ☕ Java Concepts Used

- Scanner Class
- Getter and Setter Methods
- Regular Expressions (Regex)
- Pattern Class
- Input Validation
- Method Calls
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
                    ├── validation
                    │     └── UserValidator.java
                    │
                    ├── service
                    │     └── UserProfileService.java
                    │
                    └── Main.java
```

---

## 📄 Class Description

### User.java

Represents a user in the application.

Fields:

- Name
- Email
- Password
- Phone Number
- Address
- Preference

Responsibilities:

- Store user information.
- Provide getter methods.
- Provide setter methods.
- Display user details.

---

### UserValidator.java

Validates user input.

Validation includes:

- Name
- Email
- Password
- Phone Number

---

### UserProfileService.java

Handles all profile-related operations.

Responsibilities:

- View Profile
- Update Profile
- Change Password
- Update Preference

---

### Main.java

Application entry point.

Responsibilities:

- Display menu
- Read user choice
- Call profile service methods

---

## 🔄 User Profile Management Flow

```
User
 │
 ▼
Login Successful
 │
 ▼
Profile Menu
 │
 ├──────────────┐
 │              │
 ▼              ▼
View Profile   Update Profile
 │              │
 ▼              ▼
Display Data   Validate Input
 │              │
 └──────┬───────┘
        ▼
Update User Object
        │
        ▼
Profile Updated
```

---

## 📋 Features

### 1. View Profile

Displays:

- Name
- Email
- Phone Number
- Address
- Preference

---

### 2. Update Profile

Allows user to update:

- Name
- Email
- Phone Number
- Address
- Preference

All inputs are validated before updating.

---

### 3. Change Password

Steps:

- Enter current password.
- Verify current password.
- Enter new password.
- Validate new password.
- Update password.

---

### 4. Update Preference

Allows user to update preferences like:

- Light Mode
- Dark Mode
- Email Notifications

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

### Phone Number

- Must contain exactly 10 digits.
- Should start with 6, 7, 8, or 9.

Example:

```
9876543210 ✅

1234567890 ❌
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
========== USER PROFILE MANAGEMENT ==========

1. View Profile
2. Update Profile
3. Change Password
4. Update Preference
5. Exit

Enter Your Choice : 1

========== PROFILE DETAILS ==========

Name       : Jyothish
Email      : jyothish@gmail.com
Phone      : 9876543210
Address    : Hyderabad
Preference : Light Mode
```