package pl.bartus.benzo.enzo.cryptoseckey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CryptoSecKeyApplication {

    public static void main(String[] args) {
        SpringApplication.run(CryptoSecKeyApplication.class, args);
    }

}
