package br.edu.ufape.vinculos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class VinculosApplication {

	public static void main(String[] args) {
		SpringApplication.run(VinculosApplication.class, args);
	}

	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
