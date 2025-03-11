package br.com.aula.produtos.ProdutosApi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    public Produto() {
    }

    public Produto(int id, String nome, String descricao, int quantidadeEstoque, int estoqueMinimo, int estoqueMaximo, double precoCompra, double lucro, boolean ehImportado) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidadeEstoque = quantidadeEstoque;
        this.estoqueMinimo = estoqueMinimo;
        this.estoqueMaximo = estoqueMaximo;
        this.precoCompra = precoCompra;
        this.lucro = lucro;
        this.ehImportado = ehImportado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public int getEstoqueMaximo() {
        return estoqueMaximo;
    }

    public void setEstoqueMaximo(int estoqueMaximo) {
        this.estoqueMaximo = estoqueMaximo;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public double getLucro() {
        return lucro;
    }

    public void setLucro(double lucro) {
        this.lucro = lucro;
    }

    public boolean isEhImportado() {
        return ehImportado;
    }

    public void setEhImportado(boolean ehImportado) {
        this.ehImportado = ehImportado;
    }

    public double precoVenda(){
        return precoCompra*(1+(lucro/100))*
                (ehImportado? 1.20 : 1);
    }
    public boolean estoqueBaixo(){
        return quantidadeEstoque <= estoqueMinimo;
    }

}
