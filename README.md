# UC-06 : Edit Contact

## 📌 Objective

Implement the **Edit Contact** feature for the **MyContacts App**.

A logged-in user can update the information of an existing contact such as name, phone numbers, email addresses, address, and notes.

---

## 🎯 Requirements

- Search for an existing contact.
- Edit contact information.
- Validate updated data.
- Keep old values if no new value is entered.
- Save the updated contact information.

---

## 🛠 OOP Concepts Used

- Encapsulation
- Getter Methods
- Setter Methods
- Object Modification
- Object-Oriented Design

---

## ☕ Java Concepts Used

- ArrayList
- List Interface
- Scanner
- UUID
- LocalDateTime
- Regular Expressions (Regex)
- Input Validation
- String Comparison (`equalsIgnoreCase()`)
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
- Generate a unique Contact ID.
- Store contact creation time.
- Provide getter and setter methods.
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

Handles all contact-related operations.

Responsibilities:

- Create Contact
- View Contacts
- View Contact Details
- Edit Contact

---

### Main.java

Application entry point.

Responsibilities:

- Display menu.
- Read user choice.
- Call Contact Service methods.

---

## 🔄 Edit Contact Flow

```
Logged-in User
        │
        ▼
Select "Edit Contact"
        │
        ▼
Enter Contact Name
        │
        ▼
Search Contact List
        │
   ┌────┴────┐
   │         │
 Found   Not Found
   │         │
   ▼         ▼
Enter New   Display
Values      "Contact Not Found"
   │
   ▼
Validate Input
   │
   ▼
Update Contact
   │
   ▼
Display Success Message
```

---

## 📋 Features

### 1. Edit Contact

Allows updating:

- Contact Name
- Phone Numbers
- Email Addresses
- Address
- Notes

---

### 2. Keep Existing Values

If the user presses **Enter** without typing a new value, the existing value is retained.

Example:

```
Enter New Address :

(Current address remains unchanged.)
```

---

### 3. Input Validation

Before updating:

- Contact Name is validated.
- Phone Numbers are validated.
- Email Addresses are validated.

Invalid values are rejected.

---

### 4. Search Contact

User searches a contact using the contact name.

If the contact exists:

```
Contact updated successfully.
```

Otherwise:

```
Contact not found.
```

---

## ✅ Validation Rules

### Contact Name

- First letter must be uppercase.
- Minimum 3 characters.

Example:

```
Rahul ✅

rahul ❌

Ra ❌
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

### Email Address

Must follow standard email format.

Example:

```
rahul@gmail.com ✅

rahul@gmail ❌

rahul.com ❌
```

---

## ▶️ Sample Output

```
========== EDIT CONTACT ==========

Enter Contact Name to Edit : Rahul

Enter New Contact Name : Rahul Kumar

How many new phone numbers do you want to set? 2

Enter Phone Number 1 : 9876543210

Enter Phone Number 2 : 9123456789

How many new email addresses do you want to set? 1

Enter Email Address 1 : rahulkumar@gmail.com

Enter New Address : Bangalore

Enter New Notes : Best Friend

Contact updated successfully.
```