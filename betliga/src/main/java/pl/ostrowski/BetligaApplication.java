package pl.ostrowski;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BetligaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BetligaApplication.class, args);
	}
}
