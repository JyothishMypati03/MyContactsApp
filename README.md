# UC-09 : Search Contacts

## 📌 Objective

Implement the **Search Contacts** feature for the **MyContacts App**.

A logged-in user can search contacts using different criteria such as **Name**, **Phone Number**, **Email Address**, and **Tag**.

---

## 🎯 Requirements

- Search contacts by Name.
- Search contacts by Phone Number.
- Search contacts by Email Address.
- Search contacts by Tag.
- Display all matching contacts.
- Display a message if no matching contact is found.

---

## 🛠 OOP Concepts Used

- Interface
- Polymorphism
- Encapsulation
- Composition
- Strategy Pattern (using different search criteria)

---

## ☕ Java Concepts Used

- Interface
- ArrayList
- List Interface
- Enhanced For Loop
- String Methods (`contains()`, `equalsIgnoreCase()`)
- Packages
- Collections

---

## 📂 Project Structure

```text
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
                    ├── search
                    │     ├── SearchCriteria.java
                    │     ├── NameSearchCriteria.java
                    │     ├── PhoneSearchCriteria.java
                    │     ├── EmailSearchCriteria.java
                    │     └── TagSearchCriteria.java
                    │
                    ├── service
                    │     ├── UserAuthenticationService.java
                    │     ├── UserProfileService.java
                    │     ├── ContactService.java
                    │     └── SearchService.java
                    │
                    └── Main.java
```

---

# 📄 Class Description

## SearchCriteria.java

An interface representing a search rule.

Responsibilities:

- Define one method:
    - `matches(Contact contact)`

Different search classes implement this interface.

---

## NameSearchCriteria.java

Searches contacts using the contact name.

---

## PhoneSearchCriteria.java

Searches contacts using phone numbers.

---

## EmailSearchCriteria.java

Searches contacts using email addresses.

---

## TagSearchCriteria.java

Searches contacts using tags.

---

## SearchService.java

Handles all search operations.

Responsibilities:

- Display search menu.
- Accept user input.
- Select the appropriate search strategy.
- Display matching contacts.

---

## ContactService.java

Provides access to the contact list through:

```java
getContacts()
```

---

## Main.java

Displays the Search Contacts menu and calls `SearchService`.

---

# 🔄 Search Flow

```text
Logged-in User
        │
        ▼
Select "Search Contacts"
        │
        ▼
Choose Search Type
        │
 ┌──────┼───────────────┬───────────────┐
 │      │               │               │
 ▼      ▼               ▼               ▼
Name   Phone          Email           Tag
 │      │               │               │
 └──────┴───────────────┴───────────────┘
                │
                ▼
Search Contact List
                │
        ┌───────┴────────┐
        │                │
     Match Found      No Match
        │                │
        ▼                ▼
Display Contact    Show Message
```

---

# 📋 Features

## 1. Search by Name

Search contacts using the contact name.

Example:

```
Rahul
```

Displays every contact whose name contains "Rahul".

---

## 2. Search by Phone Number

Search using any part of the phone number.

Example:

```
9876
```

Matches:

```
9876543210
```

---

## 3. Search by Email

Search contacts using an email address.

Example:

```
gmail
```

Matches:

```
rahul@gmail.com
```

---

## 4. Search by Tag

Search contacts using tags.

Example:

```
Family
```

Displays all contacts having the **Family** tag.

---

## ▶️ Sample Output

### Search by Name

```text
========== SEARCH CONTACTS ==========

1. Search by Name
2. Search by Phone
3. Search by Email
4. Search by Tag

Enter Your Choice : 1

Enter Search Value : Rahul

========== SEARCH RESULTS ==========

Contact Details

Name : Rahul

Phone : [9876543210]

Email : [rahul@gmail.com]

Address : Bangalore

Tags : [Friends]
```

---

### Search by Tag

```text
Enter Choice : 4

Enter Search Value : Friends

========== SEARCH RESULTS ==========

Rahul

Ramesh

Priya
```

---

### No Match

```text
========== SEARCH RESULTS ==========

No matching contacts found.
```