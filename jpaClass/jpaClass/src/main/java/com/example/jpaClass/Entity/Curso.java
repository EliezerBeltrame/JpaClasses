package com.example.jpaClass.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCurso;
    private String nome;
    private  int numeroSala;

    @OneToOne//1 para 1
    @JoinColumn(name = "idProfessor", referencedColumnName = "idProfessor")
    private Professor professor;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)//1 para muitos (1 --- N)
    @JsonBackReference
    private List<Aluno> alunos;

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public  Curso(){

    }

    public Curso(long idCurso, String nome, int numeroSala) {
        this.idCurso = idCurso;
        this.nome = nome;
        this.numeroSala = numeroSala;
    }


    public long getIdCurso() {
        return idCurso;
    }

    public String getNome() {
        return nome;
    }

    public int getNumeroSala() {
        return numeroSala;
    }

    public void setIdCurso(long idCurso) {
        this.idCurso = idCurso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }
}
