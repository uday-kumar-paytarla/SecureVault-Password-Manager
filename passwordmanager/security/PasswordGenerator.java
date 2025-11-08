package passwordmanager.security;

import java.security.SecureRandom;

public class PasswordGenerator {

    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS   = "0123456789";
    private static final String SYMBOLS   = "!@#$%^&*()-_=+<>?/";

    private static final String ALL_CHARACTERS = UPPERCASE + LOWERCASE + NUMBERS + SYMBOLS;

    private static final SecureRandom random = new SecureRandom();

    // Method 1: Generate password of custom length
    public String generatePassword(int length) {
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(ALL_CHARACTERS.length());
            password.append(ALL_CHARACTERS.charAt(index));
        }

        return password.toString();
    }

    // Method 2: Generate a strong default password (12 chars)
    public String generateStrongPassword() {
        return generatePassword(12);
    }
}
