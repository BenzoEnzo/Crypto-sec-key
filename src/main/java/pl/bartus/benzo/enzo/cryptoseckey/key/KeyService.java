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
        List<Key> keys = keyRepository.findAll();
        if(keys.isEmpty()){
            final Key key = new Key();
            key.setGeneratedAt(LocalDateTime.now());
            keyRepository.save(key);
        }
        return keys;
    }

    public void updateDatabase(){
       List<Key> dbKeys = getAll();
       Key key = new Key();
       if(dbKeys.isEmpty()){
           keyRepository.save(key);
       } else {
          key.updateEncryptedKey();
          key.setGeneratedAt(LocalDateTime.now());
          keyRepository.save(key);
       }
    }

    public Key findKeyById(Key key){
        return keyRepository.findById(key.getId()).orElse(null);
    }

}
