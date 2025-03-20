package com.example.jpaClass.Controller;

import com.example.jpaClass.Entity.Curso;
import com.example.jpaClass.Repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
