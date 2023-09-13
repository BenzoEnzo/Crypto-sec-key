package pl.bartus.benzo.enzo.cryptoseckey.key;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Service
public class KeyEndpoint implements KeyServiceApi{
private final KeyService keyService;

    public KeyEndpoint(KeyService keyService) {
        this.keyService = keyService;
    }

    public ResponseEntity<List<Key>> getKey(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(keyService.getAll());
    }

    public ResponseEntity<Boolean> validateKey(String encryptedKey){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(keyService.validateSecurityKey(encryptedKey));
    }
}
