package br.edu.moeda.realService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class RealServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealServiceApplication.class, args);
	}

}
