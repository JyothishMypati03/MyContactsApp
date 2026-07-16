# UC-07 : Delete Contact

## 📌 Objective

Implement the **Delete Contact** feature for the **MyContacts App**.

A logged-in user can delete an existing contact from the contact list after confirming the deletion.

---

## 🎯 Requirements

- Search for an existing contact.
- Display the contact details before deletion.
- Ask for user confirmation.
- Delete the contact from the contact list.
- Display success or cancellation message.

---

## 🛠 OOP Concepts Used

- Encapsulation
- Getter Methods
- Object-Oriented Design
- Object Removal from Collection

---

## ☕ Java Concepts Used

- ArrayList
- List Interface
- Scanner
- Enhanced For Loop
- String Comparison (`equalsIgnoreCase()`)
- Collections
- Object Searching
- Object Deletion

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
- Display contact details.

---

### ContactService.java

Handles all contact-related operations.

Responsibilities:

- Create Contact
- View Contacts
- View Contact Details
- Edit Contact
- Delete Contact

---

### Main.java

Application entry point.

Responsibilities:

- Display menu.
- Read user choice.
- Call Contact Service methods.

---

## 🔄 Delete Contact Flow

```
Logged-in User
       │
       ▼
Select "Delete Contact"
       │
       ▼
Enter Contact Name
       │
       ▼
Search Contact List
       │
 ┌─────┴─────┐
 │           │
Found     Not Found
 │           │
 ▼           ▼
Display     Show
Contact     "Contact Not Found"
 │
 ▼
Ask for Confirmation
 │
 ┌─────┴─────┐
 │           │
Yes          No
 │           │
 ▼           ▼
Delete     Cancel Delete
 │
 ▼
Display Success Message
```

---

## 📋 Features

### 1. Delete Contact

Allows the user to delete an existing contact from the contact list.

---

### 2. Search Contact

The application searches the contact using the contact name.

If found, complete contact details are displayed.

---

### 3. Confirmation Before Delete

Before deleting, the application asks:

```
Are you sure you want to delete this contact? (yes/no)
```

This helps prevent accidental deletion.

---

### 4. Delete Contact

If the user enters:

```
yes
```

The contact is removed from the contact list.

---

### 5. Cancel Delete

If the user enters:

```
no
```

The contact remains unchanged.

---

## ▶️ Sample Output

### Delete Successful

```
========== DELETE CONTACT ==========

Enter Contact Name to Delete : Rahul

Contact Found

Name : Rahul

Phone : [9876543210]

Email : [rahul@gmail.com]

Address : Bangalore

Notes : College Friend

Are you sure you want to delete this contact? (yes/no)

yes

Contact deleted successfully.
```

---

### Delete Cancelled

```
========== DELETE CONTACT ==========

Enter Contact Name to Delete : Rahul

Are you sure you want to delete this contact? (yes/no)

no

Delete cancelled.
```

---

### Contact Not Found

```
========== DELETE CONTACT ==========

Enter Contact Name to Delete : Suresh

Contact not found.
```