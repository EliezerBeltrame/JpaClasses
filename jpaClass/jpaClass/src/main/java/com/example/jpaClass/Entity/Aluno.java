package com.example.jpaClass.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAluno;
    private String nome;
    private String cpf;

    @ManyToOne//muitos pra 1 (n ---1)
    @JoinColumn(name = "idCurso", referencedColumnName = "idCurso")
    @JsonBackReference
    private Curso curso;

    public Aluno(){
    }

    public Aluno(long idAluno, String nome, String cpf) {
        this.idAluno = idAluno;
        this.nome = nome;
        this.cpf = cpf;
    }

    public long getIdAluno() {
        return idAluno;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setIdAluno(long idAluno) {
        this.idAluno = idAluno;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
