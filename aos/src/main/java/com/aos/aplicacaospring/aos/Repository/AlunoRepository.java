package com.aos.aplicacaospring.aos.Repository;

import com.aos.aplicacaospring.aos.model.Alunos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Alunos, Long> {
}
