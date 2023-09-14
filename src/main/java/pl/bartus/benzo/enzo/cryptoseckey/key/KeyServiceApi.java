package pl.bartus.benzo.enzo.cryptoseckey.key;

import org.springframework.http.ResponseEntity;
import pl.bartus.benzo.enzo.cryptoseckey.model.KeyDto;
import pl.bartus.benzo.enzo.cryptoseckey.model.verify.VerifyRequest;
import pl.bartus.benzo.enzo.cryptoseckey.model.verify.VerifyResponse;

import java.util.List;

public interface KeyServiceApi {
    ResponseEntity<List<Key>> getKey();
    ResponseEntity<VerifyResponse> validateKey(VerifyRequest verifyRequest);
}
