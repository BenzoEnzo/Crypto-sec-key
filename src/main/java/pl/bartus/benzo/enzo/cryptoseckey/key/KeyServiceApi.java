package pl.bartus.benzo.enzo.cryptoseckey.key;

import org.springframework.http.ResponseEntity;
import pl.bartus.benzo.enzo.cryptoseckey.dto.KeyDto;

import java.util.List;

public interface KeyServiceApi {
    ResponseEntity<List<Key>> getKey();
    ResponseEntity<Boolean> validateKey(KeyDto keyDto);
}
