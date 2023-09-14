package pl.bartus.benzo.enzo.cryptoseckey.key;

import org.springframework.stereotype.Service;
import pl.bartus.benzo.enzo.cryptoseckey.model.KeyDto;
import pl.bartus.benzo.enzo.cryptoseckey.model.verify.VerifyRequest;
import pl.bartus.benzo.enzo.cryptoseckey.model.verify.VerifyResponse;


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

    public VerifyResponse validateSecurityKey(VerifyRequest verifyRequest){
       final boolean isSuccess = keyRepository.findByEncryptedKey(verifyRequest.encryptedKey()).isPresent();
       return new VerifyResponse(isSuccess);
    }
}
