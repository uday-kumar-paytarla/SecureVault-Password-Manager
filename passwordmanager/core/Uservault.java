package passwordmanager.core;

import java.util.ArrayList;

public class Uservault {

    private ArrayList<PasswordEntry> entries;

    public Uservault() {
        this.entries = new ArrayList<>();
    }

    public void addEntry(PasswordEntry entry) {
        entries.add(entry);
    }

    public ArrayList<PasswordEntry> getAllEntries() {
        return entries;
    }

    public PasswordEntry getEntry(int index) {
        if (index >= 0 && index < entries.size()) {
            return entries.get(index);
        }
        return null;
    }

    public void updateEntry(int index, PasswordEntry updatedEntry) {
        if (index >= 0 && index < entries.size()) {
            entries.set(index, updatedEntry);
        }
    }

    public void deleteEntry(int index) {
        if (index >= 0 && index < entries.size()) {
            entries.remove(index);
        }
    }

    public int getSize() {
        return entries.size();
    }
}

