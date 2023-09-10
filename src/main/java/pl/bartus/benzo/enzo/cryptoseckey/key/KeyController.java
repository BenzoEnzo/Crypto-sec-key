package pl.bartus.benzo.enzo.cryptoseckey.key;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/key")
public class KeyController {
    private final KeyService keyService;
    public KeyController(KeyService keyService) {
        this.keyService = keyService;
    }
    @GetMapping()
    public ResponseEntity<List<Key>> getKey(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(keyService.getAll());
    }
    @PostMapping(value = "/verify", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> validateKey(@RequestBody String encryptedKey){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(keyService.validateSecurityKey(encryptedKey));
    }

}
