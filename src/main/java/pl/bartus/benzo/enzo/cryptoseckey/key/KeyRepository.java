package pl.bartus.benzo.enzo.cryptoseckey.key;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyRepository extends MongoRepository<Key, String> {
    Boolean existsKeyByEncryptedKey(String key);
}