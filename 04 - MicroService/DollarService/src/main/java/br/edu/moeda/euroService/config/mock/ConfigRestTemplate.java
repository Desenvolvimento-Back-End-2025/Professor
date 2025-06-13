package br.edu.moeda.euroService.config.mock;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigRestTemplate {

    @Bean
    @LoadBalanced
    public RestTemplate rest(){
        return new RestTemplate();
    }
}
