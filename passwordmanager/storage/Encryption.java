package passwordmanager.storage;

import passwordmanager.core.*;
import passwordmanager.security.*;
import java.io.*;
import java.util.ArrayList;

public class Encryption extends FileStorage {

    private static final String ENCRYPTED_FILE = "vault_encrypted.txt";
    private EncryptionStrategy encryption;

    public Encryption(EncryptionStrategy encryption) {
        this.encryption = encryption;
    }

    // Override: Save encrypted data to file
    @Override
    public void saveData(Uservault vault) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ENCRYPTED_FILE))) {

            ArrayList<PasswordEntry> entries = vault.getAllEntries();

            for (PasswordEntry entry : entries) {
                String encryptedLine = encryption.encrypt(
                        entry.getWebsite() + "," +
                        entry.getUsername() + "," +
                        entry.getEncryptedpassword() + "," +
                        entry.getNotes()
                );
                writer.write(encryptedLine);
                writer.newLine();
            }

            System.out.println("Data saved securely to " + ENCRYPTED_FILE);

        } catch (IOException e) {
            System.out.println("Error saving encrypted data: " + e.getMessage());
        }
    }

    // Override: Load and decrypt data from file
    @Override
    public Uservault loadData() {
        Uservault vault = new Uservault();

        try (BufferedReader reader = new BufferedReader(new FileReader(ENCRYPTED_FILE))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String decryptedLine = encryption.decrypt(line);
                String[] parts = decryptedLine.split(",");

                if (parts.length == 4) {
                    PasswordEntry entry = new PasswordEntry(parts[0], parts[1], parts[2], parts[3]);
                    vault.addEntry(entry);
                }
            }

            System.out.println("Data loaded and decrypted successfully from " + ENCRYPTED_FILE);

        } catch (FileNotFoundException e) {
            System.out.println("No encrypted file found — starting with an empty vault.");
        } catch (IOException e) {
            System.out.println("Error reading encrypted data: " + e.getMessage());
        }

        return vault;
    }
}
