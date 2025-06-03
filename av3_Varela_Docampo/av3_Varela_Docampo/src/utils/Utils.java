package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class Utils {
    public static int xerarRando(int max, int min){
        return new Random().nextInt((max - min) + 1) + min;
    }
    public static String hashPassword(String password) {
        try {
            // Crear unha instancia de MessageDigest para SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            
            // Pasar a contraseña como bytes ao digest
            byte[] hash = digest.digest(password.getBytes());
            
            // Convertir o hash a unha cadea hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
