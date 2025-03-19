package br.com.aula.produtos.ProdutosApi.resources;


import br.com.aula.produtos.ProdutosApi.ProdutosApiApplication;
import br.com.aula.produtos.ProdutosApi.model.Produto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoResource {

    @GetMapping("")
    public ArrayList<Produto> getAllProdutos() {
        return ProdutosApiApplication.produtos;
    }

    @GetMapping("/{id}")
    public Produto getOneProduto(@PathVariable int id) {

        return ProdutosApiApplication.produtos.get(id);
    }

    @GetMapping("/find")
    public Produto findByNome(@RequestParam String nome) {
        for (Produto p : ProdutosApiApplication.produtos) {
            if(p.getNome().contains(nome)) {
                return p;
            }
        }
        return null;
    }

    @GetMapping("/protected")
    public ArrayList<Produto> getProdutoSecured(@RequestHeader String token) {
        if (!token.equals("123")) {
            return null;
        }
        return ProdutosApiApplication.produtos;
    }

    @PostMapping("")
    public Produto save( @Valid @RequestBody Produto produto) {
        produto.setId(ProdutosApiApplication.produtos.size()+1);
        ProdutosApiApplication.produtos.add(produto);
        return produto;
    }

    @DeleteMapping("/{id}")
    public Produto deleteProduto(@PathVariable int id) {
        if (id < ProdutosApiApplication.produtos.size()){
            Produto p = ProdutosApiApplication.produtos.get(id);
            ProdutosApiApplication.produtos.remove(id);
            return p;
        }else{
            return null;
        }
    }

    @PutMapping("/{id}/venda/{qtde}")
    public Produto realizarVenda(@PathVariable int id, @PathVariable int qtde) {
        Produto p = ProdutosApiApplication.produtos.get(id);
        p.setQuantidadeEstoque( p.getQuantidadeEstoque() - qtde );
        return p;
    }

    @GetMapping("/teste")
    public Produto getProduto(){
        return ProdutosApiApplication.produtos.get(0);
    }

    @PostMapping("/teste")
    public Produto getProduto1(){
        return ProdutosApiApplication.produtos.get(1);
    }

}
