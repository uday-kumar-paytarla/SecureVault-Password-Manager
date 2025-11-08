package passwordmanager.storage;

import java.io.*;
import passwordmanager.core.*;
import java.util.ArrayList;

public class FileStorage {

    private static final String FILE_NAME = "vault_data.txt";

    // Save user vault to a file
    public void saveData(Uservault vault) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {

            ArrayList<PasswordEntry> entries = vault.getAllEntries();

            for (PasswordEntry entry : entries) {
                writer.write(entry.getWebsite() + "," +
                             entry.getUsername() + "," +
                             entry.getEncryptedpassword() + "," +
                             entry.getNotes());
                writer.newLine();
            }

            System.out.println(" Data saved successfully to " + FILE_NAME);

        } catch (IOException e) {
            System.out.println(" Error saving data: " + e.getMessage());
        }
    }

    // Load user vault from a file
    public Uservault loadData() {
        Uservault vault = new Uservault();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length == 4) {
                    PasswordEntry entry = new PasswordEntry(parts[0], parts[1], parts[2], parts[3]);
                    vault.addEntry(entry);
                }
            }

            System.out.println(" Data loaded successfully from " + FILE_NAME);

        } catch (FileNotFoundException e) {
            System.out.println(" File not found — starting with empty vault.");
        } catch (IOException e) {
            System.out.println(" Error reading file: " + e.getMessage());
        }

        return vault;
    }
}
