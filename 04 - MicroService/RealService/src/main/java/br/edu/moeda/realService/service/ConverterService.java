package br.edu.moeda.realService.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

@Service
public class ConverterService {

    @Value("${moeda.base.euro}")
    private double valorBaseEuro;
    @Value("${moeda.base.dollar}")
    private double valorBaseDollar;

    public double convertToEuro(double valor) {
        Random random = new Random(new Date().getTime());
        return valor * (valorBaseEuro * (1+(random.nextDouble() * 0.1 - 0.05)   ));
    }

    public double convertToDollar(double valor) {
        Random random = new Random(new Date().getTime());
        return valor * (valorBaseDollar * (1+(random.nextDouble() * 0.1 - 0.05)   ));
    }
}
