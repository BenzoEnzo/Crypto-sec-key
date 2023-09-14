package pl.bartus.benzo.enzo.cryptoseckey.key;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.bartus.benzo.enzo.cryptoseckey.model.TokenUtil;
import pl.bartus.benzo.enzo.cryptoseckey.model.verify.VerifyRequest;
import pl.bartus.benzo.enzo.cryptoseckey.model.verify.VerifyResponse;

import java.util.List;


@Service
public class KeyEndpoint implements KeyServiceApi{
private final KeyService keyService;

    public KeyEndpoint(KeyService keyService) {
        this.keyService = keyService;
    }

    public ResponseEntity<List<Key>> getKey(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(keyService.getAll());
    }

    public ResponseEntity<VerifyResponse> validateKey(VerifyRequest verifyRequest){
        final VerifyResponse verifyResponse = keyService.validateSecurityKey(verifyRequest);
        if(verifyResponse.isSuccess()){
            final String sessionToken = TokenUtil.createToken(verifyRequest.encryptedKey());
            return ResponseEntity.status(HttpStatus.OK)
                    .header(HttpHeaders.AUTHORIZATION, "Bearer " + sessionToken)
                    .body(verifyResponse);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(verifyResponse);
        }
    }
}
