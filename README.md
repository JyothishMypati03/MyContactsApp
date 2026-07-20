# UC-10 : Advanced Filtering

## 📌 Objective

Implement the **Advanced Filtering** feature for the **MyContacts App**.

A logged-in user can filter contacts by **Tag**, **Date Added**, and **Frequently Contacted**. The user can also combine multiple filters and sort the filtered results.

---

## 🎯 Requirements

- Filter contacts by Tag.
- Filter contacts by Date Added.
- Filter contacts by Frequently Contacted.
- Combine multiple filters together.
- Sort filtered contacts by name.
- Sort filtered contacts by contact count.
- Display matching contacts.
- Display a message if no matching contact is found.

---

## 🛠 OOP Concepts Used

- Interface
- Polymorphism
- Encapsulation
- Composition
- Object-Oriented Design
- Strategy Pattern
- Composite Pattern

---

## ☕ Java Concepts Used

- ArrayList
- List Interface
- Set Interface
- Comparator
- Stream API
- Lambda Expressions
- Functional Interfaces
- Enhanced For Loop
- LocalDate
- LocalDateTime
- String Methods
- Packages

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
                    ├── filter
                    │     ├── FilterCriteria.java
                    │     ├── TagFilterCriteria.java
                    │     ├── DateAddedFilterCriteria.java
                    │     ├── FrequentlyContactedFilterCriteria.java
                    │     └── CompositeFilterCriteria.java
                    │
                    ├── service
                    │     ├── UserAuthenticationService.java
                    │     ├── UserProfileService.java
                    │     ├── ContactService.java
                    │     ├── SearchService.java
                    │     └── ContactFilterService.java
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
- Store creation date.
- Store contact count.
- Store last contacted time.
- Display contact details.

---

### FilterCriteria.java

An interface for filtering contacts.

Responsibilities:

- Define one method:
    - `matches(Contact contact)`

---

### TagFilterCriteria.java

Filters contacts by tag.

---

### DateAddedFilterCriteria.java

Filters contacts based on creation date.

---

### FrequentlyContactedFilterCriteria.java

Filters contacts based on contact count.

---

### CompositeFilterCriteria.java

Combines multiple filters into one filter.

---

### ContactFilterService.java

Handles advanced filtering operations.

Responsibilities:

- Display filter menu.
- Accept user input.
- Apply selected filter.
- Sort filtered results.
- Display matching contacts.

---

### Main.java

Application entry point.

Responsibilities:

- Display menu.
- Read user choice.
- Call filter service methods.

---

## 🔄 Advanced Filtering Flow

```text
Logged-in User
       │
       ▼
Select "Advanced Filtering"
       │
       ▼
Choose Filter Type
       │
 ┌─────┼───────────────┬────────────────────┐
 │     │               │                    │
 ▼     ▼               ▼                    ▼
Tag   Date Added   Frequently Contacted   Combine Filters
 │     │               │                    │
 └─────┴───────────────┴────────────────────┘
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

## 📋 Features

### 1. Filter by Tag

Shows contacts that contain a selected tag.

Example:

```text
Family
```

Displays contacts tagged with **Family**.

---

### 2. Filter by Date Added

Shows contacts created on or after a selected date.

Example:

```text
2026-07-01
```

Displays contacts added after that date.

---

### 3. Filter by Frequently Contacted

Shows contacts whose contact count is above a selected minimum.

Example:

```text
5
```

Displays contacts contacted 5 or more times.

---

### 4. Combine Multiple Filters

Allows combining filters like:

- Tag + Date Added
- Tag + Frequently Contacted
- Date Added + Frequently Contacted
- All three together

---

### 5. Sort Filtered Results

Filtered contacts can be sorted by:

- Name
- Contact Count

---

## ▶️ Sample Output

### Filter by Tag

```text
========== ADVANCED FILTERS ==========

1. Filter by Tag
2. Filter by Date Added
3. Filter by Frequently Contacted
4. Combine Filters
5. Sort by Name
6. Sort by Frequently Contacted

Enter Your Choice : 1

Enter Tag : Family

========== FILTER RESULTS ==========

Contact Details
Name : Rahul
Tags : [Family]
```

---

### Sort by Name

```text
Enter Your Choice : 5

========== FILTER RESULTS ==========

Rahul
Ramesh
Priya
```

---

### No Match

```text
========== FILTER RESULTS ==========

No matching contacts found.
```