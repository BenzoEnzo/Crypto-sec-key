package pl.bartus.benzo.enzo.cryptoseckey.endpoint;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pl.bartus.benzo.enzo.cryptoseckey.key.KeyService;
import pl.bartus.benzo.enzo.cryptoseckey.xml.request.VerifySecurityKeyRequest;
import pl.bartus.benzo.enzo.cryptoseckey.xml.response.VerifySecurityKeyResponse;

@Endpoint
public class VerifySecurityKeyEndpoint {
    private static final String NAMESPACE_URI = "https://www.enzo-security.gl/crypto";

    private final KeyService keyService;

    @Autowired
    public VerifySecurityKeyEndpoint(KeyService keyService) {
        this.keyService = keyService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "VerifySecurityKeyRequest")
    @ResponsePayload
    public VerifySecurityKeyResponse verifySecurityKey(@RequestPayload VerifySecurityKeyRequest request) {
        VerifySecurityKeyResponse response = new VerifySecurityKeyResponse();
        response.setIsValid(keyService.validateSecurityKey(request.getEncryptedKey()));
        return response;
    }
}
