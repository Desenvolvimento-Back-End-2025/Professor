package br.edu.moeda.euroService.resource;


import br.edu.moeda.euroService.service.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/euro")
public class ConverterResource {

    @Autowired
    ConverterService service;

    @GetMapping("/{valor}/dollar")
    public ResponseEntity<?> dollar( @PathVariable double valor ) {

        double valorEmEuro = service.convertToDolar(valor);
        return ResponseEntity.ok(valorEmEuro);
    }

    @GetMapping("/{valor}/real")
    public ResponseEntity<?> real(@PathVariable double valor){

        double valorEmReal = service.convertToReal(valor);
        return ResponseEntity.ok(valorEmReal);
    }

}
