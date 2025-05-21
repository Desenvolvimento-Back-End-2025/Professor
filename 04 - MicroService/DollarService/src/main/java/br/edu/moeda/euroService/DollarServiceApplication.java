package br.edu.moeda.euroService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class DollarServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DollarServiceApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate rest(){
		return new RestTemplate();
	}

}
