package com.example.jpaClass.Controller;

import com.example.jpaClass.Entity.Curso;
import com.example.jpaClass.Repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public ResponseEntity<Curso> created(@RequestBody Curso curso){
        Curso cursoBd = cursoRepository.save(curso);
        return ResponseEntity.ok(cursoBd);
    }
    @GetMapping
    public ResponseEntity<List<Curso>> getAll(){
        return  ResponseEntity.ok(cursoRepository.findAll());
    }
    @PutMapping("{idcurso}")
    public ResponseEntity<Curso> findAll(Curso curso){
        Optional<Curso> cursoBd = cursoRepository.findById(curso);
    }

    //@DeleteMapping

}
