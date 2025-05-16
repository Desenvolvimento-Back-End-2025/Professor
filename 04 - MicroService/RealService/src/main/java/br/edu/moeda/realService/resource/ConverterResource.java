package br.edu.moeda.realService.resource;

import br.edu.moeda.realService.service.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/real")
public class ConverterResource {

    @Autowired
    ConverterService service;

    @GetMapping("/{valor}/euro")
    public ResponseEntity<?> euro( @PathVariable double valor ) {

        double valorEmEuro = service.convertToEuro(valor);
        return ResponseEntity.ok(valorEmEuro);
    }

    @GetMapping("/{valor}/dollar")
    public ResponseEntity<?> real(@PathVariable double valor){

        double valorEmReal = service.convertToDollar(valor);
        return ResponseEntity.ok(valorEmReal);
    }

}
