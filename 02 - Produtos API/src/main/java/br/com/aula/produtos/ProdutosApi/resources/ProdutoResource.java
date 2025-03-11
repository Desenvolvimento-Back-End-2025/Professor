package br.com.aula.produtos.ProdutosApi.resources;


import br.com.aula.produtos.ProdutosApi.ProdutosApiApplication;
import br.com.aula.produtos.ProdutosApi.model.Produto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produtos/")
public class ProdutoResource {

    @GetMapping("/teste")
    public Produto getProduto(){
        return ProdutosApiApplication.produtos.get(0);
    }
    @PostMapping("/teste")
    public Produto getProduto1(){
        return ProdutosApiApplication.produtos.get(1);
    }

}
