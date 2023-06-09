package com.aos.aplicacaospring.aos.Repository;

import com.aos.aplicacaospring.aos.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    
}
