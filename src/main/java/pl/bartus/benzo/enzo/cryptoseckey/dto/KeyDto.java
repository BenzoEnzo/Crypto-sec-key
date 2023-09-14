package pl.bartus.benzo.enzo.cryptoseckey.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KeyDto {
    private String encryptedKey;
    private boolean isSuccess;
    public KeyDto(){
    }
    public KeyDto(boolean isSuccess){
        this.isSuccess = isSuccess;
    }

    public KeyDto(String encryptedKey){
        this.encryptedKey = encryptedKey;
    }
}
