package br.edu.moeda.euroService.config.mock;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
public class ConfigRestTemplateMock {


    @Bean("restTemplateMock")
    public RestTemplate rest(List<ClientHttpRequestInterceptor> lista){
        RestTemplate rst = new RestTemplate();
        rst.setInterceptors(lista);
        return rst;
    }

}
