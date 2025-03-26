package br.com.aula.produtos.ProdutosApi.service;

import br.com.aula.produtos.ProdutosApi.ProdutosApiApplication;
import br.com.aula.produtos.ProdutosApi.model.Cliente;
import br.com.aula.produtos.ProdutosApi.model.Produto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public ArrayList<Cliente> getAllClientes() {
        return ProdutosApiApplication.clientes;
    }

    public ArrayList<Cliente> getClientesSemCompras() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        for (Cliente cliente : ProdutosApiApplication.clientes) {
            if (cliente.getProdutos() == null || cliente.getProdutos().isEmpty()) {
                clientes.add(cliente);
            }
        }
        return clientes;
    }


    public List<Cliente> getClientesComCompras() {
        return ProdutosApiApplication.clientes.stream()
                .filter( c -> c.getProdutos()!= null && c.getProdutos().size()>0)
                .toList();
    }

    public boolean realizaCompra(Integer idCliente, Integer idProduto, Integer qtde) throws Exception {
        if (!searchCliente(idCliente)){
            throw new Exception("Cliente "+idCliente+" não existe");
        }
        if (!searchProduto(idProduto)){
            throw new Exception("Produto "+idProduto+" não existe");
        }
        Produto p = ProdutosApiApplication.produtos.get(idProduto);
        if (p.getQuantidadeEstoque() < qtde){
            throw new Exception("Produto "+idProduto+" não tem estoque suficiente");
        }
        Cliente c = ProdutosApiApplication.clientes.get(idCliente);
        if (c.getProdutos() == null){
            c.setProdutos(new ArrayList<>());
        }
        c.getProdutos().add(p);
        p.setQuantidadeEstoque( p.getQuantidadeEstoque() - qtde);

        return true;
    }

    private boolean searchProduto(Integer idProduto) {
        return ProdutosApiApplication.produtos.size() > idProduto;
    }

    private boolean searchCliente(Integer idCliente) {
        return ProdutosApiApplication.clientes.size() > idCliente;
    }
}
