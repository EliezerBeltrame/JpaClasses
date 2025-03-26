package com.example.jpaClass.Controller;

import com.example.jpaClass.Entity.Curso;
import com.example.jpaClass.Repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        public ResponseEntity<Curso> created(@RequestBody Curso curso) {
        Curso cursoBd = cursoRepository.save(curso);
        return ResponseEntity.ok(cursoBd);
        }

   @GetMapping
        public ResponseEntity<List<Curso>> getAll() {
        return ResponseEntity.ok(cursoRepository.findAll());
        }

 //  @GetMapping("/{id}")
        //public ResponseEntity<Curso> getById(@PathVariable Long id) {
          //  Optional<Curso> OptionalCurso = cursoRepository.findById(id);
           // if (OptionalCurso.isPresent()) {
             //   Curso curso = OptionalCurso.get();
            //    return ResponseEntity.status(HttpStatus.FOUND).body(curso);
           // } else {
            //    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
          //  }

   @PutMapping("{id}")
        public ResponseEntity<Object> update (@PathVariable Long id, @RequestBody Curso updateCurso){
                Optional<Curso> optionalCurso = cursoRepository.findById(id);

                if (optionalCurso.isPresent()) {
                    Curso curso = optionalCurso.get();
                    curso.setNome(updateCurso.getNome());
                    curso.setNumeroSala(updateCurso.getNumeroSala());
                    curso.setProfessor(updateCurso.getProfessor());

                    return ResponseEntity.ok(cursoRepository.save(curso));
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso não encontrado");
                }
            }
   @DeleteMapping("/{id}")
        public ResponseEntity<String> delete (@PathVariable Long id){
                Optional<Curso> OptionalCurso = cursoRepository.findById(id);

                if (OptionalCurso.isPresent()) {
                    Curso curso = OptionalCurso.get();
                    cursoRepository.delete(curso);
                    return ResponseEntity.ok("Curso deletado com sucesso");
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso não encontrado");
                }
            }
        }
//}
