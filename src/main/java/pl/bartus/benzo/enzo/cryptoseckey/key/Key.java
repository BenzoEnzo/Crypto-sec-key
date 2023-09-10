package pl.bartus.benzo.enzo.cryptoseckey.key;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalDateTime;

@Document(collection = "keys")
@Setter
@Getter
public class Key {
    @Id
    private String id;
    private String encryptedKey;
    private LocalDateTime generatedAt;
    public void updateEncryptedKey(){
        try {
            SecureRandom secureRandom = new SecureRandom();
            String randomString = new BigInteger(130, secureRandom).toString(32);
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(randomString.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder(2 * hash.length);
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            this.encryptedKey = hexString.toString();
        } catch (NoSuchAlgorithmException ignored) {}
    }
    public Key(){}
}
