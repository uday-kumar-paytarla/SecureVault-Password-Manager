package passwordmanager.security;

import java.util.Base64;

public class AESEncryption implements EncryptionStrategy {

    @Override
    public String encrypt(String plainText) {
        return Base64.getEncoder().encodeToString(plainText.getBytes());
    }

    @Override
    public String decrypt(String encryptedText) {
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedText);
        return new String(decodedBytes);
    }
}
