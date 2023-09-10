package pl.bartus.benzo.enzo.cryptoseckey.xml.request;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "https://www.enzo-security.gl/crypto")
public class VerifySecurityKeyRequest {
    private String encryptedKey;

    @XmlElement
    public String getEncryptedKey() {
        return encryptedKey;
    }

    public void setEncryptedKey(String encryptedKey) {
        this.encryptedKey = encryptedKey;
    }
}
