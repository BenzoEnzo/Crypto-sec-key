package pl.bartus.benzo.enzo.cryptoseckey.key;


import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class KeyService {
    private final KeyRepository keyRepository;
    public KeyService(KeyRepository keyRepository){
        this.keyRepository = keyRepository;
    }

    public List<Key> getAll(){
        return keyRepository.findAll();
    }

    public void getOrCreate(){
        Optional<Key> optionalKey = keyRepository.findFirstBy();
        Key key = optionalKey.orElseGet(Key::new);
        key.updateEncryptedKey();
        key.setGeneratedAt(LocalDateTime.now());
        keyRepository.save(key);
    }
}
