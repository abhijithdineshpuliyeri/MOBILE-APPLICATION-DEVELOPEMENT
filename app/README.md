# SmartLibrary – Android Application

## Aim
To develop a simple Android-based SmartLibrary application that allows users to browse available books, issue a book, view library rules, and access library contact information.

## Project Overview
SmartLibrary is a simple Android application developed using Kotlin and XML. The application demonstrates basic Android concepts such as Activities, Views, Explicit Intents, and Android Notifications.

## Main Features
- SmartLibrary home screen
- Library logo and application description
- List of available books
- Issue book functionality
- Book issue confirmation screen
- Android system notification after successfully issuing a book
- Automatic return to the Home screen after issuing a book
- Library rules screen
- Contact library screen

## Application Flow

Home
|
+-- Books
|     |
|     +-- Select Book
|           |
|           +-- Issue Book
|                 |
|                 +-- Confirm Issue
|                       |
|                       +-- Notification
|                       |
|                       +-- Return to Home
|
+-- Library Rules
|
+-- Contact Library

## Technologies Used
- Android Studio
- Kotlin
- XML
- Android SDK
- Android Notification API

## Project Structure

app/
├── manifests/
│   └── AndroidManifest.xml
├── kotlin+java/
│   └── com.example.smartlibraryle1/
│       ├── MainActivity.kt
│       ├── BooksActivity.kt
│       ├── IssueActivity.kt
│       ├── RulesActivity.kt
│       └── ContactActivity.kt
└── res/
    └── layout/
        ├── activity_main.xml
        ├── activity_books.xml
        ├── activity_issue.xml
        ├── activity_rules.xml
        └── activity_contact.xml

## Android Components Used

### Activities
The project uses separate Activities for the main screen, books, issue confirmation, library rules, and contact information.

### Explicit Intent
Explicit Intents are used to navigate between Activities. For example:

```kotlin
val intent = Intent(this, BooksActivity::class.java)
startActivity(intent)
```

### Views
The application uses:
- TextView – to display text and book information
- Button – to perform actions and navigation
- ImageView – to display the library logo
- LinearLayout – to arrange UI elements
- ScrollView – to display scrollable content

### Notification
After a book is successfully issued, the application creates an Android system notification using `NotificationCompat` and a `NotificationChannel`.

Example notification:
> SmartLibrary – The Alchemist has been issued successfully.

On Android 13 and above, notification permission is requested from the user.

## Books Included
The current application contains example books such as:
- The Alchemist – Paulo Coelho
- Atomic Habits – James Clear
- Clean Code – Robert C. Martin
- Harry Potter – J. K. Rowling
- Rich Dad Poor Dad – Robert Kiyosaki

## Result
The SmartLibrary Android application successfully provides a simple interface for browsing and issuing books. It also provides library rules and contact information. After confirming a book issue, a notification is displayed in the Android notification bar and the user is returned to the Home screen.

## Conclusion
The project demonstrates the basic concepts of Android application development using Kotlin and XML. It shows how Activities, Views, Explicit Intents, and Notifications can be combined to create a simple and functional library application.

## Future Improvements
- Add user login and registration
- Add a database for storing books and users
- Add search and filter functionality
- Track issued and returned books
- Add due dates and reminders
- Add a librarian/admin panel
- Use Fragments for improved navigation and screen management

## Author
SmartLibrary – Android Application
