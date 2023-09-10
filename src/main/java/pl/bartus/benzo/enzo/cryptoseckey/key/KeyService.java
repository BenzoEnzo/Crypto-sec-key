package pl.bartus.benzo.enzo.cryptoseckey.key;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;


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
        Key key = keyRepository.findFirstBy().orElseGet(Key::new);
        key.updateEncryptedKey();
        key.setGeneratedAt(LocalDateTime.now());
        keyRepository.save(key);
    }

    public boolean validateSecurityKey(String securityKey){
        return keyRepository.findKeyByEncryptedKey(securityKey).isPresent();
    }
}
