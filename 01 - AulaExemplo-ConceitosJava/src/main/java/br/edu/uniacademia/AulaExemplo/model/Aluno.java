package br.edu.uniacademia.AulaExemplo.model;

public class Aluno {
    //Atributos
    private String nome;
    private int idade;
    private double nota;

    //Construtores
    public Aluno(){
        nome = "";
        idade = 0;
        nota = 0;
    }
    public Aluno(String nome){
        this.nome = nome;
        nota = 0;
        idade = 0;
    }
    public Aluno(String nome, int idade, double nota) {
        this.nome = nome;
        this.idade = idade;
        this.nota = nota;
    }

    //Métodos de acesso
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public boolean estaAprovado() {
        return (nota >= 6);
    }
}
