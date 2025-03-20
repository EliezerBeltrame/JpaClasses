package com.example.jpaClass.Repository;

import com.example.jpaClass.Entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{

}

