package com.example.jpaClass.Repository;

import com.example.jpaClass.Entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {

}
