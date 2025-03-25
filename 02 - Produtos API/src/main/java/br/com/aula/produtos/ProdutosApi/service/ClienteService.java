package br.com.aula.produtos.ProdutosApi.service;

import br.com.aula.produtos.ProdutosApi.ProdutosApiApplication;
import br.com.aula.produtos.ProdutosApi.model.Cliente;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ClienteService {

    public Cliente saveCliente(Cliente cliente) throws Exception {
        if (cliente.idade() <= 18){
            throw new Exception("Cliente não pode ser menor de idade");
        }
        cliente.setId( ProdutosApiApplication.clientes.size());
        ProdutosApiApplication.clientes.add(cliente);
        return cliente;
    }

    public void saveAllClientes(@Valid ArrayList<Cliente> clientes) throws Exception {
        for (Cliente cliente : clientes) {
            saveCliente(cliente);
        }
    }
}
