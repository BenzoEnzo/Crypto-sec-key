package pl.bartus.benzo.enzo.cryptoseckey.key;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/key")
public class KeyController {
    private final KeyService keyService;

    public KeyController(KeyService keyService) {
        this.keyService = keyService;
    }
    @GetMapping()
    public ResponseEntity<List<Key>> getKeys(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(keyService.getAll());
    }
}
