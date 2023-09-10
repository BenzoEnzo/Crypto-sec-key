package pl.bartus.benzo.enzo.cryptoseckey.xml.response;


import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "https://www.enzo-security.gl/crypto")
public class VerifySecurityKeyResponse {
    private boolean isValid;

    @XmlElement
    public boolean isValid() {
        return isValid;
    }

    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }
}