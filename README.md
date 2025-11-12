# SecureVault-Password-Manager
# Overview

SecureVault is a console-based Password Manager built entirely using Java and Object-Oriented Programming (OOP) principles.
It securely stores, encrypts, and manages user credentials in a local encrypted file.

This project demonstrates the use of Java OOP concepts such as classes, objects, encapsulation, inheritance, interfaces, and polymorphism, along with file handling and basic encryption.

# Features

 1.Add New Password

 2.Save credentials for any website or service.

 3.Includes optional notes for reference.

 4.View Saved Passwords

 5.Displays all stored credentials in decrypted form.

 6.Passwords are automatically decrypted for display but remain encrypted on disk.

 7.Delete Password

 8.Delete specific entries from your vault using their index number.

 9.Generate Strong Passwords

 10.Automatically create secure random passwords using uppercase, lowercase, numbers, and symbols.

 11.Encrypted Storage

 12.All passwords are encrypted and saved to vault_encrypted.txt using Base64 encoding.

 13.Persistent Storage

On restart, all passwords are automatically loaded and decrypted from the saved file.

# Technologies Used

Language: Java

Concepts:

Encapsulation

Inheritance

Polymorphism

Interfaces

Packages

File Handling

Exception Handling

Project Structure
SECURE VAULT/
│
└── passwordmanager/
    ├── Main.java
    ├── core/
    │   ├── PasswordEntry.java
    │   └── UserVault.java
    ├── security/
    │   ├── EncryptionStrategy.java
    │   ├── AESEncryption.java
    │   └── PasswordGenerator.java
    ├── storage/
    │   ├── FileStorage.java
    │   └── Encryption.java
    └── ui/
        └── ConsoleUI.java

File Descriptions
File	Description
PasswordEntry.java	Defines the data structure for each password entry.
UserVault.java	Stores all password entries in memory.
EncryptionStrategy.java	Interface defining the contract for encryption/decryption.
AESEncryption.java	Implements Base64 encryption and decryption logic.
PasswordGenerator.java	Generates secure random passwords.
FileStorage.java	Handles file reading and writing for basic storage.
Encryption.java	Extends FileStorage to add encryption-based saving and loading.
ConsoleUI.java	Handles user interaction via command-line menus.
Main.java	Entry point that starts the application.
How to Compile and Run

Open a Command Prompt and navigate to the project folder:

cd "C:\Users\payta\OneDrive\Attachments\Desktop\SECURE VAULT"


Compile all source files:

javac passwordmanager\core\*.java passwordmanager\security\*.java passwordmanager\storage\*.java passwordmanager\ui\*.java passwordmanager\main.java


(Use javac (Get-ChildItem -Path passwordmanager -Recurse -Filter *.java).FullName if using PowerShell.)

Run the application:

java passwordmanager.main

Example Console Output
No encrypted file found — starting with an empty vault.
Welcome to SecureVault Password Manager

========= MENU =========
1)  Add New Password
2)  View All Passwords
3)  Delete Password
4)  Generate Strong Password
5)  Save & Exit
Enter your choice: 1
Enter website: Gmail
Enter username: uday@gmail.com
Enter password: MySecure@123
Enter notes (optional): personal email
Password added successfully!

Encrypted File Location

All saved passwords are stored in:

vault_encrypted.txt


This file is created in your project root directory.
Its contents are encrypted and not human-readable.
The data is automatically decrypted when you relaunch the program.

OOP Concepts Used

Encapsulation – Data members are private, accessed via getters/setters.

Inheritance – Encryption extends FileStorage for added functionality.

Polymorphism – Implemented via EncryptionStrategy interface.

Abstraction – Complex details of encryption are hidden from the user.

Packages – Classes are grouped by function (core, security, storage, ui).

Future Improvements

Implement AES-256 encryption instead of Base64.

Add password strength checker.

Create GUI using JavaFX or Swing.

Allow user authentication before accessing vault.

Author

Developed by: Uday Kumar
Project Title: SecureVault Password Manager
Language: Java
Platform: Console-based Application