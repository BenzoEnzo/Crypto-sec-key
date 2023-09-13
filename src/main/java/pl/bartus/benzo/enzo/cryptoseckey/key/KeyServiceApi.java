package pl.bartus.benzo.enzo.cryptoseckey.key;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface KeyServiceApi {
    ResponseEntity<List<Key>> getKey();
    ResponseEntity<Boolean> validateKey(String encryptedKey);
}
