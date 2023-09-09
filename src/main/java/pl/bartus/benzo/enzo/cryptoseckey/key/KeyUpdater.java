package pl.bartus.benzo.enzo.cryptoseckey.key;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class KeyUpdater {
    private final KeyService keyService;

    public KeyUpdater(KeyService keyService) {
        this.keyService = keyService;
    }

    @Scheduled(fixedDelay = 5)
    public void updateKeys() {
        keyService.updateDatabase();
        System.out.println("Security key updated !");
    }
}
