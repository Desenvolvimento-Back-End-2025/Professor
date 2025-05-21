package br.edu.moeda.euroService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EuroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EuroServiceApplication.class, args);
	}

}
