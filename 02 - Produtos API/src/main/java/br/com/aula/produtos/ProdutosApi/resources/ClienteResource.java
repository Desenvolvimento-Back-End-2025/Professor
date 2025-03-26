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
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("")
    public ResponseEntity<?> getAllClientes() {
        ArrayList<Cliente> clientes = cs.getAllClientes();
        if(clientes.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não há clientes cadastrados");
        }
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/compras")
    public ResponseEntity<?> getClienteComCompras() {
        List<Cliente> clientes = cs.getClientesComCompras();
        if(clientes.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não há clientes com compras");
        }
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/compras/no")
    public ResponseEntity<?> getClienteSemCompras() {
        ArrayList<Cliente> clientes = cs.getClientesSemCompras();
        if(clientes.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não há clientes sem compras");
        }
        return ResponseEntity.ok(clientes);
    }

    @PostMapping("/{idCliente}/compras/{idProduto}/{qtde}")
    public ResponseEntity<?> comprarProduto(@PathVariable Integer idCliente,
                                            @PathVariable Integer idProduto,
                                            @PathVariable Integer qtde ) {
        try {
            cs.realizaCompra(idCliente, idProduto, qtde);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
        return ResponseEntity.ok("Compra realizada com sucesso");
    }


}
