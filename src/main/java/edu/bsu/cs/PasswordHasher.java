package edu.bsu.cs;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHasher {

    public static String hash(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }

    public static boolean verify(String password, String hashedPassword) {
        String computedHash = hash(password);
        System.out.println("DEBUG: Verifying password. Input hash = " + computedHash + ", Stored hash = " + hashedPassword);
        return computedHash.equals(hashedPassword);
    }
}
