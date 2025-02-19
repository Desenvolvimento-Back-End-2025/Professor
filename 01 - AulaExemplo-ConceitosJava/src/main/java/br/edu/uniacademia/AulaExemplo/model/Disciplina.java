package br.edu.uniacademia.AulaExemplo.model;

import java.util.ArrayList;

public class Disciplina {
    private String nome;
    private int cargaHoraria;
    private Professor professor;
    private ArrayList<Aluno> alunos;

    public Disciplina() {
        alunos = new ArrayList<>();
    }
    public Disciplina(String nome, int cargaHoraria) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        alunos = new ArrayList<>();
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
}
