package pl.bartus.benzo.enzo.cryptoseckey.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KeyDto {
    private boolean isSuccess;
    private String encryptedKey;
    public KeyDto(){

    }
    public KeyDto(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public KeyDto(String encryptedKey) {
        this.encryptedKey = encryptedKey;
    }

    public KeyDto(boolean isSuccess, String encryptedKey) {
        this.isSuccess = isSuccess;
        this.encryptedKey = encryptedKey;
    }

}
