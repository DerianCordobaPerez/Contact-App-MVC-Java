package Configuration;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class EncryptPassword {
    private static final Random randomNumber = new SecureRandom();
    private static final String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int iterations = 10000, keyLength = 256;
    public static String salt = "PBKDF2WithHmacSHA1";

    public static String getSalt(int length) {
        StringBuilder returnValue = new StringBuilder(length);
        for(int i = 0; i < length; ++i)
            returnValue.append(alphabet.charAt(randomNumber.nextInt(alphabet.length())));
        return new String(returnValue);
    }

    public static byte[] hash(char[] password, byte[] salt) {
        PBEKeySpec keySpec = new PBEKeySpec(password, salt, iterations, keyLength);
        Arrays.fill(password, Character.MIN_VALUE);
        try {
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            return secretKeyFactory.generateSecret(keySpec).getEncoded();
        } catch(NoSuchAlgorithmException | InvalidKeySpecException exception) {
            throw new AssertionError("Error while hashing a password: " + exception.getMessage(), exception);
        } finally {
            keySpec.clearPassword();
        }
    }

    public static String generateSecurePassword(String password, String salt) {
        byte[] securePassword = hash(password.toCharArray(), salt.getBytes());
        String returnValue = Base64.getEncoder().encodeToString(securePassword);
        return returnValue;
    }

    public static boolean verifyUserPassword(String providePassword, String securePassword, String salt) {
        String newSecurePassword = generateSecurePassword(providePassword, salt);
        return newSecurePassword.equalsIgnoreCase(securePassword);
    }
}
