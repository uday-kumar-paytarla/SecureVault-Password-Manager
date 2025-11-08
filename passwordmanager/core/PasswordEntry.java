package passwordmanager.core;

public class PasswordEntry {
    private String website;
    private String username;
    private String encryptedpassword;
    private String notes;

    public PasswordEntry(String website, String username, String encryptedpassword, String notes) {
this.website = website;
this.username = username;
this.encryptedpassword = encryptedpassword;
this.notes = notes;
    }

    public String getWebsite(){
        return website;
    }
    public void setWebsite(String website){
this.website = website;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getEncryptedpassword(){
        return encryptedpassword;
    }
    public void setEncryptedpassword(String encryptedpassword){
        this.encryptedpassword = encryptedpassword;
    }
    public String getNotes(){
        return notes;
    }
    public void setNotes(String notes){
        this.notes = notes;
    }

    @Override
    public String toString(){
        return "Website: " + website +
        "\nUsername: " + username +
        "\nPassword: **********" +
        "\nNotes: " + notes;
    }
}

