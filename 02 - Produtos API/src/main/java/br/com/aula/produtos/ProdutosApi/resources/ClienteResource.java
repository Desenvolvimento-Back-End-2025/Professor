package br.com.aula.produtos.ProdutosApi.resources;


import br.com.aula.produtos.ProdutosApi.ProdutosApiApplication;
import br.com.aula.produtos.ProdutosApi.model.Cliente;
import br.com.aula.produtos.ProdutosApi.service.ClienteService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Past;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/cliente")
public class ClienteResource {

    @Autowired
    ClienteService cs;

    //CRUD
    @PostMapping("")
    public ResponseEntity<?> saveCliente(@Valid @RequestBody Cliente cliente) {
        try {
            Cliente cli = cs.saveCliente(cliente);
            return ResponseEntity.ok(cli);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/all")
    public ResponseEntity<?> saveAllCliente(
            @Valid @RequestBody ArrayList<Cliente> clientes) {
        try {
            cs.saveAllClientes(clientes);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return new ResponseEntity<>("Não foi possível salvar todos os clientes",
                    HttpStatus.BAD_REQUEST);
        }
    }

}
