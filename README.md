# UC-12 : Apply Tags to Contacts

## 📌 Objective

Implement the **Apply Tags to Contacts** feature for the **MyContacts App**.

A logged-in user can assign **one or multiple tags** to a contact for better organization and categorization.

---

## 🎯 Requirements

- Apply one or more tags to a contact.
- Create a tag automatically if it does not already exist.
- Remove tags from a contact.
- View contacts based on tags.
- Display all contacts along with their assigned tags.

---

## 🛠 OOP Concepts Used

- Encapsulation
- Composition
- Association (Contact ↔ Tag)
- Many-to-Many Relationship
- Object-Oriented Design

---

## ☕ Java Concepts Used

- Set Interface
- LinkedHashSet
- HashSet
- Collections
- Enhanced For Loop
- Scanner
- equals()
- hashCode()
- UUID
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
                    │     ├── Contact.java
                    │     └── Tag.java
                    │
                    ├── validation
                    │     ├── UserValidator.java
                    │     ├── ContactValidator.java
                    │     └── TagValidator.java
                    │
                    ├── auth
                    │     ├── Authentication.java
                    │     ├── BasicAuthentication.java
                    │     └── SessionManager.java
                    │
                    ├── service
                    │     ├── UserAuthenticationService.java
                    │     ├── UserProfileService.java
                    │     ├── ContactService.java
                    │     ├── SearchService.java
                    │     ├── ContactFilterService.java
                    │     └── TagService.java
                    │
                    └── Main.java
```

---

# 📄 Class Description

## Tag.java

Represents a tag.

Responsibilities:

- Store tag name.
- Store associated contact IDs.
- Override `equals()`.
- Override `hashCode()`.

---

## Contact.java

Represents a contact.

Responsibilities:

- Store contact information.
- Store multiple tags.
- Add tags.
- Remove tags.

---

## TagValidator.java

Validates tag names.

Responsibilities:

- Check tag format.
- Allow only valid names.

---

## TagService.java

Handles all tag operations.

Responsibilities:

- Create Tag
- View Tags
- Apply Tags to Contact
- Remove Tag from Contact
- Search Contacts by Tag
- Display Contacts with Tags

---

## Main.java

Application entry point.

Responsibilities:

- Display menu.
- Read user input.
- Call TagService methods.

---

# 🔄 Apply Tags Flow

```text
Logged-in User
        │
        ▼
Select "Apply Tags"
        │
        ▼
Choose Contact
        │
        ▼
Enter Number of Tags
        │
        ▼
Enter Tag Names
        │
        ▼
Check Tag Exists
        │
   ┌────┴─────┐
   │          │
 Exists     Not Exists
   │          │
   │      Create Tag
   │          │
   └────┬─────┘
        ▼
Assign Tag to Contact
        │
        ▼
Display Success Message
```

---

# 📋 Features

## 1. Create Tag

Create a custom tag.

Example:

```text
Family

Friends

Work
```

---

## 2. Apply Multiple Tags

Assign multiple tags to one contact.

Example:

```text
Contact

Rahul

↓

Tags

Family

Friends

Work
```

Result:

```text
Rahul

Tags

Family

Friends

Work
```

---

## 3. Remove Tag

Remove a tag from a contact.

Example:

```text
Rahul

↓

Remove

Friends
```

---

## 4. Search by Tag

Find contacts using a tag.

Example:

```text
Family
```

Output:

```text
Rahul

Priya
```

---

## 5. View Contacts with Tags

Display every contact along with assigned tags.

Example:

```text
Rahul -> [Family, Friends]

Ramesh -> [Work]

Priya -> [Family]
```

---

# ▶️ Sample Output

## Apply Tags

```text
========== APPLY TAGS TO CONTACT ==========

Enter Contact Name :

Rahul

How many tags do you want to apply?

3

Enter Tag 1 :

Family

Enter Tag 2 :

Friends

Enter Tag 3 :

Office

Tags applied successfully.
```

---

## Remove Tag

```text
========== REMOVE TAG FROM CONTACT ==========

Enter Contact Name :

Rahul

Enter Tag Name :

Friends

Tag removed successfully.
```

---

## Search by Tag

```text
========== SEARCH CONTACTS BY TAG ==========

Enter Tag Name :

Family

Rahul

Priya
```

---

## View Contacts with Tags

```text
========== CONTACTS WITH TAGS ==========

Rahul -> [Family, Friends]

Ramesh -> [Office]

Priya -> [Family]
```
