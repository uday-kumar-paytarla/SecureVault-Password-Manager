package passwordmanager.ui;

import java.util.Scanner;
import passwordmanager.core.*;
import passwordmanager.security.*;
import passwordmanager.storage.*;

public class ConsoleUI {

    private Uservault vault;
    private Encryption storage;
    private EncryptionStrategy encryption;
    private PasswordGenerator generator;
    private Scanner scanner;

    public ConsoleUI() {
        encryption = new AESEncryption();
        storage = new Encryption(encryption);
        vault = storage.loadData();
        generator = new PasswordGenerator();
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to SecureVault Password Manager 🔐");

        while (true) {
            System.out.println("\n========= MENU =========");
            System.out.println("1️.Add New Password");
            System.out.println("2️.View All Passwords");
            System.out.println(" 3️.Delete Password");
            System.out.println(" 4️.Generate Strong Password");
            System.out.println(" 5️.Save & Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addPassword();
                    break;
                case 2:
                    viewPasswords();
                    break;
                case 3:
                    deletePassword();
                    break;
                case 4:
                    generateStrongPassword();
                    break;
                case 5:
                    storage.saveData(vault);
                    System.out.println("Vault saved securely. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void addPassword() {
        System.out.print("Enter website: ");
        String website = scanner.nextLine();
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter notes (optional): ");
        String notes = scanner.nextLine();

        String encryptedPassword = encryption.encrypt(password);
        PasswordEntry entry = new PasswordEntry(website, username, encryptedPassword, notes);
        vault.addEntry(entry);

        System.out.println("Password added successfully!");
    }

    private void viewPasswords() {
        if (vault.getSize() == 0) {
            System.out.println("No passwords saved yet.");
            return;
        }

        System.out.println("\n========= STORED PASSWORDS =========");
        int index = 1;
        for (PasswordEntry entry : vault.getAllEntries()) {
            System.out.println(index + ". " + entry.getWebsite());
            System.out.println("   Username: " + entry.getUsername());
            System.out.println("   Password: " + encryption.decrypt(entry.getEncryptedpassword()));
            System.out.println("   Notes: " + entry.getNotes());
            System.out.println("---------------------------------");
            index++;
        }
    }

    private void deletePassword() {
        viewPasswords();
        if (vault.getSize() == 0) return;

        System.out.print("Enter the number of the password to delete: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (index <= 0 || index > vault.getSize()) {
            System.out.println("⚠️ Invalid index.");
        } else {
            vault.deleteEntry(index - 1);
            System.out.println("✅ Password deleted successfully.");
        }
    }

    private void generateStrongPassword() {
        String newPassword = generator.generateStrongPassword();
        System.out.println("Your generated strong password: " + newPassword);
    }
}
