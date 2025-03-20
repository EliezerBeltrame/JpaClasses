package com.example.jpaClass.Controller;


import com.example.jpaClass.Entity.Professor;
import com.example.jpaClass.Repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @PostMapping
    public ResponseEntity<Professor> created(@RequestBody Professor professor){
        Professor professorBd = professorRepository.save(professor);
        return ResponseEntity.ok(professor);
    }
}
