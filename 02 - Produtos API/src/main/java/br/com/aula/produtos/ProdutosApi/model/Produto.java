package br.com.aula.produtos.ProdutosApi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
    private int id;
    private String nome;
    private String descricao;
    private int quantidadeEstoque;
    private int estoqueMinimo;
    private int estoqueMaximo;
    private double precoCompra;
    private double lucro;
    private boolean ehImportado;

    public double precoVenda(){
        return precoCompra*(1+(lucro/100))*
                (ehImportado? 1.20 : 1);
    }
    public boolean estoqueBaixo(){
        return quantidadeEstoque <= estoqueMinimo;
    }

}
