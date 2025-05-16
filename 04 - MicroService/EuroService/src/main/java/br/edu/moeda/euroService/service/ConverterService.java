package br.edu.moeda.euroService.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

@Service
public class ConverterService {

    @Value("${moeda.base.dolar}")
    private double valorBaseDolar;
    @Value("${moeda.base.real}")
    private double valorBaseReal;

    public double convertToDolar(double valor) {
        Random random = new Random(new Date().getTime());
        return valor * (valorBaseDolar * (1+(random.nextDouble() * 0.1 - 0.05)   ));
    }

    public double convertToReal(double valor) {
        Random random = new Random(new Date().getTime());
        return valor * (valorBaseReal * (1+(random.nextDouble() * 0.1 - 0.05)   ));
    }
}
