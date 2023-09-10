package pl.bartus.benzo.enzo.cryptoseckey.unit;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import pl.bartus.benzo.enzo.cryptoseckey.key.Key;
import pl.bartus.benzo.enzo.cryptoseckey.key.KeyRepository;
import pl.bartus.benzo.enzo.cryptoseckey.key.KeyService;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SpringBootTest
public class KeyServiceTests {
    @Mock
    private KeyRepository keyRepository;

    @InjectMocks
    private KeyService keyService;

    private Key testKey;

    @BeforeEach
    public void setup() {
        testKey = new Key();
        testKey.setId("testId");
        testKey.setEncryptedKey("kluczMSGSZYFRY");
    }

    @Test
    public void testValidateSecurityKey() {
        when(keyRepository.findKeyByEncryptedKey(anyString())).thenReturn(Optional.of(testKey));

        boolean isValid = keyService.validateSecurityKey("kluczMSGSZYFRY");

        assertTrue(isValid);
    }

    @Test
    public void testValidateSecurityKeyInvalid() {
        boolean isValid = keyService.validateSecurityKey("kluczMSGSZYFRYk");

        assertFalse(isValid);
    }

    @Test
    public void testCreateIfNotExist() {
        when(keyRepository.findFirstBy()).thenReturn(Optional.of(testKey));

        keyService.getOrCreate();

        verify(keyRepository, times(1)).save(any(Key.class));
        verify(keyRepository, times(1)).findFirstBy();
    }

}
