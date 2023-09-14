package pl.bartus.benzo.enzo.cryptoseckey.integration;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bartus.benzo.enzo.cryptoseckey.model.KeyDto;
import pl.bartus.benzo.enzo.cryptoseckey.key.Key;
import pl.bartus.benzo.enzo.cryptoseckey.key.KeyServiceApi;
import pl.bartus.benzo.enzo.cryptoseckey.model.verify.VerifyRequest;
import pl.bartus.benzo.enzo.cryptoseckey.model.verify.VerifyResponse;

import java.util.List;

@RestController
@RequestMapping("/api/key")
public class KeyController {
    private final KeyServiceApi keyServiceApi;
    public KeyController(KeyServiceApi keyServiceApi) {
        this.keyServiceApi = keyServiceApi;
    }
    @GetMapping()
    public ResponseEntity<List<Key>> getKey(){
        return keyServiceApi.getKey();
    }
    @PostMapping(value = "/verify", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VerifyResponse> validateKey(@RequestBody VerifyRequest verifyRequest){
        return keyServiceApi.validateKey(verifyRequest);
    }

}
