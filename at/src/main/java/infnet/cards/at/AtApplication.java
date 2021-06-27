package infnet.cards.at;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class AtApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtApplication.class, args);
	}

	// Bean q o rest template pede no console pra funcionar
	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
}
