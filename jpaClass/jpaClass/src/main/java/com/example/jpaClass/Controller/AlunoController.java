package com.example.jpaClass.Controller;

import com.example.jpaClass.Entity.Aluno;
import com.example.jpaClass.Entity.Curso;
import com.example.jpaClass.Entity.Professor;
import com.example.jpaClass.Repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @PostMapping
    public ResponseEntity<Aluno> created(@RequestBody Aluno aluno) {
        Aluno alunoBd = alunoRepository.save(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(aluno);
    }
    @GetMapping
    public ResponseEntity<List<Aluno>> getAll(){
        return  ResponseEntity.ok(alunoRepository.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> getById(@PathVariable Long id){
        Optional<Aluno> OptionalAluno = alunoRepository.findById(id);
        if (OptionalAluno.isPresent()){
            Aluno aluno = OptionalAluno.get();
            return  ResponseEntity.ok(aluno);
        }else {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Aluno updateAluno) {
        Optional<Aluno> optionalAluno = alunoRepository.findById(id);

        if (optionalAluno.isPresent()) {
            Aluno aluno = optionalAluno.get();
            aluno.setNome(updateAluno.getNome());
            aluno.setCpf(updateAluno.getCpf());
            aluno.setCurso(updateAluno.getCurso());

            return ResponseEntity.ok(alunoRepository.save(aluno));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ALuno não encontrado");
        }
    }
        @DeleteMapping("/{id}")
        public ResponseEntity<Object> delete(@PathVariable Long id){
            Optional<Aluno> OptionalAluno = alunoRepository.findById(id);

            if (OptionalAluno.isPresent()) {
                Aluno aluno = OptionalAluno.get();
                alunoRepository.delete(aluno);
                return ResponseEntity.ok("Aluno deletado com sucesso");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado");
            }
        }

    }

