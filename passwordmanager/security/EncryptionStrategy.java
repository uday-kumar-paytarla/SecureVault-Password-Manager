package passwordmanager.security;

public interface EncryptionStrategy {
    String encrypt(String plainText);
    String decrypt(String encryptedText);
}
