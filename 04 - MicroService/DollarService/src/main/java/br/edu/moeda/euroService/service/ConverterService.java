package br.edu.moeda.euroService.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.Random;

@Service
public class ConverterService {

    @Value("${moeda.base.euro}")
    private double valorBaseEuro;
    @Value("${moeda.base.real}")
    private double valorBaseReal;

    @Autowired
    RestTemplate rest;
    @Autowired
    @Qualifier("restTemplateMock")
    RestTemplate restMock;

    public double convert(double valor) {
        double valor1 = rest.getForEntity("http://EUROSERVICE/euro/"+valor+"/dollar",
                Double.class).getBody();

        double valor2 = restMock.getForEntity("http://EUROSERVICE/teste",
                Double.class).getBody();

        return valor1 + valor2;
    }

    public double convertToEuro(double valor) {
        Random random = new Random(new Date().getTime());
        return valor * (valorBaseEuro * (1+(random.nextDouble() * 0.1 - 0.05)   ));
    }

    public double convertToReal(double valor) {
        Random random = new Random(new Date().getTime());
        return valor * (valorBaseReal * (1+(random.nextDouble() * 0.1 - 0.05)   ));
    }

}
